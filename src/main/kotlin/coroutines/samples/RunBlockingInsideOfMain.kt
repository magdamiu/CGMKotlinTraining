package coroutines.samples

import kotlinx.coroutines.*
import java.time.Instant
import java.time.format.DateTimeFormatter

fun main() {
    GlobalScope.launch {
        println("before 500 delay ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
        delay(500L)
        println("after 500 delay ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
        println("Kotlin")
    }
    println("before hello ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    println("Hello")
    runBlocking {
        println("first in block ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
        delay(1000L)
        println("after delay in block ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    }
    println("before ! ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    println("!")
}
