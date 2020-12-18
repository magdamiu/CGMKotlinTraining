package coroutines.code_challenges

import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

fun main(vararg args: String) = runBlocking {
    val api: GithubApi = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(GithubApi::class.java)

    val downloadedRepos = api.searchRepositories("kotlin").await().list

    downloadedRepos
        .sortedByDescending { it.stars }
        .forEach {
            it.apply {
                println("$fullName ⭐$stars\n$description\n$url\n")
            }
        }

    println(downloadedRepos.size)

/*    api.searchUsers("jacob").await().list
        .take(20)
        .sortedBy { it.login }
        .forEach { println(it.login) }*/

}

interface GithubApi {
    // Api docs:
    // https://developer.github.com/v3/search/#search-repositories
    // example call https://api.github.com/search/repositories?q=kotlin
    @GET("/search/repositories")
    fun searchRepositories(@Query("q") searchQuery: String): Deferred<Response>

    @GET("/search/users")
    fun searchUsers(@Query("q") searchQuery: String): Deferred<UserResponse>
}

data class Response(
    @SerializedName("items")
    val list: Collection<Repository>
)

data class Repository(
    val id: Long?,
    val name: String?,
    val description: String?,
    @SerializedName("full_name") val fullName: String?,
    @SerializedName("html_url") val url: String?,
    @SerializedName("stargazers_count") val stars: Long?
)

data class UserResponse(
    @SerializedName("items")
    val list: Collection<User>
)

data class User(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val received_events_url: String,
    val type: String,
    val score: Int,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val events_url: String,
    val site_admin: Boolean
)

