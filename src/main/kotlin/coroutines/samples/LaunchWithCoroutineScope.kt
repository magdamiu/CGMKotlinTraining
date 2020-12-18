package coroutines.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val jobWithCoroutineScope = launch {
        val suspendLambda = suspend {
            delay(1000)
            println("suspend lambda inside of launch with coroutine scope")
        }
        suspendLambda()
    }

    jobWithCoroutineScope.join()
}
