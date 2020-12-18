package coroutines.samples

/*
fun main() {
    val job = launch {
        try {
           println("hello")
        } catch (e: CancellationException){
            println("work is cancelled")
        } finally {
            withContext(NonCancellable){
                delay(1000L)
                println("cleanup is done")
            }
        }
    }
    delay(1000L)
    println("Cancel!")
    job.cancel()
    println("Done!")

}*/
