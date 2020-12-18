package coroutines

import kotlinx.coroutines.*

// CC3

fun main() = runBlocking<Unit> {
    launch {
        println("Starting progressbar animation")
        displayProgressLoading(150)
        println("Loading is done")
    }
}

private suspend fun displayProgressLoading(times: Int) {
    val progressBarLength = 50
    var currentPosition = 0
    repeat (times) {
        val progressbar = (0 until progressBarLength).joinToString("") { if (it == currentPosition) " " else "░" }
        print(progressbar)

        delay(50)

        if (currentPosition == progressBarLength) {
            currentPosition = 0
        }
        currentPosition++
        print("\r")
    }
}
