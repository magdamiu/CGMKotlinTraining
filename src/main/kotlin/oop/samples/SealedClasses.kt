package oop.samples

class Movie(val name: String)
sealed class MovieSearchResult
data class MovieFound(val movie: Movie) : MovieSearchResult()
object MovieNotFound : MovieSearchResult()
object DatabaseOffline : MovieSearchResult()

val <T> T.exhaustive: T
    get() = this

fun displayMovieResult(movieResult: MovieSearchResult) {
    when(movieResult) {
        is MovieFound -> println("yey, we found the movie")
        is MovieNotFound -> TODO()
        DatabaseOffline -> TODO()
    }.exhaustive
}
