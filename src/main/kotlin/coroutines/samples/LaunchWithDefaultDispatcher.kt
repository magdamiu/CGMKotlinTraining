package coroutines.samples

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    yield()
    println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    yield()
    println("end task2 in Thread ${Thread.currentThread()}")
}


fun main() {
    println("start")
    runBlocking {
        launch(Dispatchers.Default) { task1() }
        launch { task2() }

        println("called task1 and task2 from ${Thread.currentThread()}")
    }
    println("done")
}
