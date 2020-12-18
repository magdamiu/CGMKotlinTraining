package kotlin_1_4

fun main() {
    var numbers = listOf(1, 3, 5, 2, 6, 8)
    checkNumbers(numbers)
}

fun checkNumbers(numbers: List<Int>) {
    for (number in numbers) {
        when {
            number % 2 == 0 -> continue // it goes to the next iteration
            number % 3 == 0 -> break // exit the loop
            else -> println(number)
        }
    }
}

val rulesMap: Map<String, (String?) -> Boolean> =
    mapOf(
        "weak" to { it != null },
        "medium" to { !it.isNullOrBlank() },
        "strong" to {
            it != null &&
                    "^[a-zA-Z0-9]+$".toRegex().matches(it)
        }
    )

