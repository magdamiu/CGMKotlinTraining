package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// CC1

fun main() = runBlocking {
    printCurrentThreadName()
    val time = measureTimeMillis {
        cookRice()
        prepareMeat()
        cutVegetables()
        rollTheSarmale()
    }
    println("Completed in $time ms")
}

private suspend fun cookRice() {
    println("Starting to cook rice on ${getCurrentThreadName()}")
    delay(500)
    println("Rice cooked")
}

private suspend fun prepareMeat() {
    println("Starting to prepare meat on ${getCurrentThreadName()}")
    delay(1500)
    println("meat prepared")
}

private suspend fun cutVegetables() {
    println("Starting to cut vegetables on ${getCurrentThreadName()}")
    delay(1500)
    println("Vegetables ready")
}

private suspend fun rollTheSarmale() {
    println("Starting to roll the sarmale on ${getCurrentThreadName()}")
    delay(2000)
    println("sarmale rolled")
}

private fun printCurrentThreadName() {
    println("Running on ${getCurrentThreadName()}")
}

private fun getCurrentThreadName(): String = Thread.currentThread().name