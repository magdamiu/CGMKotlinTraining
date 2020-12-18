package coroutines.samples

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    GlobalScope.launch {
        delay(1000L)
        println("Kotlin!")
    }
    println("Hello,")
    delay(2000L)
}

