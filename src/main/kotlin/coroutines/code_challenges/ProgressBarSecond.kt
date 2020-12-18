package coroutines.code_challenges

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

fun main() = runBlocking {
    val job = launch { displayProgressLoading(1000)}
    delay(5000)
    job.cancel()
    job.join()
    println("\nJob cancelled and completed")
}
// conclusions
// In the end, our code is going to display a progress-bar animation for five seconds and then stop it.
/* You can also make use of a Job extension function, called cancelAndJoin(), that combines the cancel() and join() calls together. However, if you don't want to wait for the actual coroutine stop-event, a simple cancel() call is enough.*/