package functions.code_challenges

// CC1
fun String.hasSpaces(): Boolean {
    val found = this.find { it == ' ' }
    return found != null
}

// CC2
val sum = { left: Int, right: Int -> left + right }

/*V2:
val sum = { left: Int, right: Int -> left + right }*/

// CC3
fun fizzbuzz(from: Int, to: Int, transformation: (Int) -> String) {
    for (number in from..to) {
        println(transformation(number))
    }
}

// CC4
val a = 1;
val b = 2;
val c = 3;

val lambda: (Int) -> Int = { a * it * it + b * it + c }

// val lambda: (Int) -> Int = { x -> a * (x * x) + b * x + c }
// val lambda = { x: Int -> a * x * x + b * x + c }

fun main() {
    println(lambda(4))
    println("1 + 3 = ${sum(1, 3)}")
    println("3 + 6 = ${sum(3, 6)}")
    println("83 + 134 = ${sum(83, 134)}")

    fizzbuzz(1, 100) { number ->
        if (number % 15 == 0) {
            return@fizzbuzz "fizzbuzz"
        }
        if (number % 3 == 0) {
            return@fizzbuzz "fizz"
        }
        if (number % 5 == 0) {
            return@fizzbuzz "buzz"
        }
        return@fizzbuzz number.toString()
    }
}