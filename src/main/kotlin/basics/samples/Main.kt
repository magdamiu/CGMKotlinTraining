package basics.samples
// byte
val myByte : Byte = 10

// integer
val myInteger = 22

// long
val myLong = 3000L

// float
val myFloat = 123.45F

var numbers = arrayOf(1, 2, 3, 4, 5, "dad", "test")


// type inference (it is not necessary to specify the type)
// the compiles know that this variable isa Boolean
val aTrueValue = true

var basicKotlin = "Basic Kotlin"

// val = value
// var = variable



fun main() {

    val countOfEvenNumbers: Int = 10
    // countOfEvenNumbers = 11

    var sumOfNumbers = 0
    sumOfNumbers = 12

    var sum : Int
    sum = 12
    sum = 90

    println("Hello Kotlin")
    println("Magda Miu")

    val firstWord = "Learn "
    val secondWord = "Kotlin"
    var bothWords = "$firstWord $secondWord"
    println(bothWords)

    // "Learn Kotlin" has 13
    // raw string
    println(""""$bothWords" has ${bothWords.length}""")

    // if

    if(firstWord.length > secondWord.length) {
        println(">")
    } else {
        println("<=")
    }
    val number = 0
    val result = if (number > 0) {
        "Positive number"
    } else if (number < 0) {
        "Negative number"
    } else {
        "Zero"
    }
    println(result)

    // when

    val firstValue = 6
    val secondValue = 3
    val operator = "/"
    val resultOfOperation = when (operator) {
        "+" -> firstValue + secondValue
        "-" -> firstValue - secondValue
        "*" -> firstValue * secondValue
        "/" -> firstValue / secondValue
        else -> "$operator operator is invalid."
    }
    println("When sample result = $resultOfOperation")

    // when with range
    var age = 18
    when (age) {
        in 1..18 -> print("Age is in the range")
        !in 18..110 -> print("Age is outside the range")
        else -> print("None of the above")
    }

    // when with type check

    var sum2 = 234
    when (sum2) {
        is Int -> println("The sum is $sum2")
        else -> println("It is not an Int")
    }

    // for
    for (index in 1..10) {
        println(index)
    }

    for (index in 12 downTo 0 step 2) {
        println(index)
    }

    // for with index
    var languages = arrayOf("Java", "Kotlin", "Scala", "C#")
    for (item in languages)
        println(item)

    var desserts = arrayOf("Cupcake", "Ice cream", "Eclair", "Pie")
    for (item in desserts.indices) {
        if (desserts[item].length > 4)
            println(desserts[item])
    }

    // equality checks
    val countries = setOf("Java", "JavaScript", "Swift")
    val neighbors = setOf("Swift", "JavaScript", "Java")

    println(countries == neighbors)
    println(countries !== neighbors)

    // String is a not-nullable type
    var name : String = "magda"

    // ? = nullable type
    var lastName: String? = null

    // Elvis operator
    val fullName: String? = "kotlin"
    val lengthOfName = fullName?.length ?: -1
    println("Elvis operator; result is $lengthOfName")
}
