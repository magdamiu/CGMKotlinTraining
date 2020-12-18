package coroutines.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("coroutineContext = $coroutineContext")
    val job = launch {
        println("coroutineContext = $coroutineContext")
        repeat(1_000_000) {
            launch(coroutineContext) {
                delay(500)
                print('.')
            }
        }
    }
    job.join()
}
