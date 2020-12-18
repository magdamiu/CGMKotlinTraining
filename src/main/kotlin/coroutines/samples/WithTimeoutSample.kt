package coroutines.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() {
    runBlocking {
        withTimeout(1000L) {
            repeat(50) { waitingTime ->
                println("Job is waiting $waitingTime...")
                delay(100L)
            }
        }
    }
}
