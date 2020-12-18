package coroutines.samples

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

fun main() {
    Executors.newFixedThreadPool(
        Runtime.getRuntime()
            .availableProcessors()
    ).asCoroutineDispatcher().use { context ->
        println("start")
        runBlocking {
            launch(context) { task1() }
            launch { task2() }
            println("called task1 and task2 from ${Thread.currentThread()}")
        }
        println("done")
    }
}