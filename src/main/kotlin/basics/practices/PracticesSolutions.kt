package basics.practices

class PracticesSolutions

fun main() {
    var dayOfTheWeek: String? = "Monday"
    dayOfTheWeek = "Tuesday"

    val currentYear = 2020
    //currentYear = 2021

    dayOfTheWeek = null
    var monday = null
    monday = dayOfTheWeek

    var nullTest: Int? = 12
    var result = nullTest?.inc() ?: 0
    println(result)

    var eclair = "eclair"
    var pizza = "pizza"
    var pie = "pie"
    println("I enjoy eating $eclair, $pizza and $pie")

    var catName = "tontonel"
    var resultAssesmentCatName = when (catName.length) {
        0 -> "Error: please use a proper name for the cat"
        in 3..12 -> "Good cat name"
        else -> "OK cat name"
    }
    println(resultAssesmentCatName)
}