package kotlin_1_4

// functional interface
fun interface Action {
    fun run()
}
fun runAction(a: Action) = a.run()

fun main() {
    runAction {
        println("new feature in Kotlin 1.4")
    }
}