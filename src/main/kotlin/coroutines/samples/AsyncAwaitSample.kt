package coroutines.samples

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun add(a: Int, b: Int): Int {
    return a + b
}

fun main() = runBlocking {
    println("Start main")
    val sumOf2 = async {
        println("Start sumOf2")
        add(2, 4)
    }
    val sumOf3 = async {
        println("Start sumOf3")
        add(3, 7)
    }
    println("Awaiting the sums")
    val total = sumOf2.await() + sumOf3.await()
    println("Total is $total")

    println("End main")
}
