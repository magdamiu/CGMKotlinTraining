package oop.code_challenges

// CC1
data class BankAccount(val deposited: Long, val withdrawn: Long) {
    val balance: Long = deposited - withdrawn
}

// CC2
data class Site(val address: String, val foundationYear: Int)

fun makeReddit(): Site {
    return Site("reddit.com", 2005)
}

// CC3 is in A file

// CC4 is in Games file

// CC5

object Math {
    fun abs(value: Int) = if (value >= 0) value else 0 - value
    fun abs(value: Double) = if (value >= 0.0) value else 0.0 - value
}

// CC6
class Task(val name: String)

object Manager {
    fun solveTask(task: Task) {
        solvedTask++
        println("Task ${task.name} solved!")
    }

    var solvedTask: Int = 0
}