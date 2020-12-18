package coroutines.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Start main")
    val job = launch {
        repeat(300) { waitingTime ->
            println("Job is waiting $waitingTime...")
            delay(50L)
        }
    }
    delay(300L)
    println("Stop waiting. Let's cancel it...")
    job.cancel()
    job.join()
    println("End main")
}
