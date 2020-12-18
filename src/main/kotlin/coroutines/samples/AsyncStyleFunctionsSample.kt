package coroutines.samples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// The result type of somethingUsefulOneAsync is Deferred<Int>
fun localIdAsync() = GlobalScope.async {
    getLocalId()
}

// The result type of somethingUsefulTwoAsync is Deferred<Int>
fun globalIdAsync() = GlobalScope.async {
    getGlobalId()
}

fun main() {
    val time = measureTimeMillis {
        val one = localIdAsync()
        val two = globalIdAsync()
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}
