package coroutines.samples

import kotlinx.coroutines.*
import java.time.Instant
import java.time.format.DateTimeFormatter

fun main() {
    var kotlin = "kotlin"
    GlobalScope.launch {
        println("before 1000 delay ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
        delay(1000L)
        println(kotlin)
        println("after Kotlin ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    }
    println("before hello ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
    println("Hello,")
    Thread.sleep(2000L)
    println("finish ${DateTimeFormatter.ISO_INSTANT.format(Instant.now())}")
}
