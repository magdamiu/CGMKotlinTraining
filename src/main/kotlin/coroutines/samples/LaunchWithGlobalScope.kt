package coroutines.samples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val jobWithGlobalScope = GlobalScope.launch {
        println("hello")
        val suspendLambda = suspend {
            delay(3000)
            println("Suspend lambda inside of launch with Global scope")
        }
        suspendLambda()
    }
    println("hello 2")
    ///jobWithGlobalScope.join()
}
