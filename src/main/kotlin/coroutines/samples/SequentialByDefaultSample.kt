package coroutines.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun getLocalId(): Int {
    println("start getLocalId")
    delay(1000L)
    println("end getLocalId")
    return 1
}

suspend fun getGlobalId(): Int {
    println("start getGlobalId")
    delay(1000L)
    println("end getGlobalId")
    return 10
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = getLocalId()
        val two = getGlobalId()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}
