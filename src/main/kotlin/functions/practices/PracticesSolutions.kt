package functions.practices

import kotlin.math.pow


fun isEven(number: Int): Boolean {
    if (number % 2 == 0) {
        return true
    } else {
        return false
    }
}

fun isEvenV2(number: Int) = number % 2 == 0

fun powerOf(value: Double, power: Double = 2.0) = value.pow(power)

fun getFullName(firstName: String, lastName: String): String {
    return "$firstName $lastName"
}

infix fun Int.toThePowerOf(number: Int) = this.toDouble().pow(number.toDouble()).toInt()

fun displayFullName(vararg names: String) {
    println("I have ${names.size} names")
}

// <language>kotlin</language>
fun String.tagify(tag: String) = "<$tag>$this</$tag>"

fun main() {
    println(getFullName(lastName = "training", firstName = "kotlin"))

    5.toThePowerOf(3)
    5 toThePowerOf 4

    displayFullName()
    displayFullName("maria")
    displayFullName("maria", "magdalena", "miu")

    println("kotlin".tagify("language"))
}