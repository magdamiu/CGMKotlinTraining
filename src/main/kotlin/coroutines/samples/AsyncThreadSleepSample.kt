package coroutines.samples

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    println("before async")
    val job = async {
        println("before sleep")
        Thread.sleep(5000)
        /*delay(5000)*/
        println("after delay")
        coroutineScope {
            println("second coroutine")
        }
        println("after sleep")
    }
    println("after async")
    job.await()
    println("after await")

}