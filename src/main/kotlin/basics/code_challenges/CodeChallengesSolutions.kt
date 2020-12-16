package basics.code_challenges

// CC1
fun secondsInAYear() : Int {
    return 365 * 24 * 3600;
}

// CC2
fun sumOfEven(n: Int): Int {
    var result = 0
    for (i in 1..n) {
        if (i % 2 == 0) {
            result += i
        }
    }
    return result
}

// CC3
fun downcase(s: String?): String = s?.toLowerCase() ?: ""


// CC4
fun sumFirstAndLast(list: List<Int>): Int =
    when {
        list.isEmpty() -> 0
        list.size == 1 -> list.first()
        else -> list.first() + list.last()
    }

// CC5
fun temperature(temperature: Int): String =
    when {
        temperature >= 25 -> "Hot"
        temperature in 15..24 -> "Warm"
        temperature in 5..14 -> "Cool"
        temperature in -5..4 -> "Cold"
        else -> "Freezing"
    }


fun main() {
    println(secondsInAYear())
    println(sumOfEven(10))
}