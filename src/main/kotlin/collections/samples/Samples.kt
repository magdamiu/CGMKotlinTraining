package collections.samples

fun main() {
    // Pair
    // to is an infix function
    val yellowScarf = "yellow" to "scarf"
    println(yellowScarf.first) // => yellow
    println(yellowScarf.second) // => scarf

    // Nesting with parentheses
    val clothes = ("yellow" to "scarf") to ("blue" to "blouse")
    println(clothes.second.first) // => blue
    println(clothes.second.second) // => blouse

    // Triple
    var kotlinVersions = Triple(1.1, 1.2, 1.3)
    var firstKotlinVersion = kotlinVersions.first
    var secondKotlinVersion = kotlinVersions.second
    var thirdKotlinVersion = kotlinVersions.third

    // combine different data types
    var kotlinBook = Triple(1289, "Learn Kotlin from GDE", 21.99)
    println("ISBN = ${kotlinBook.first} , Title = ${kotlinBook.second} , Price = ${kotlinBook.third}")

    // destructuring declarations
    val (isbn, title, price) = kotlinBook
    println(isbn)

    // List
    val numbersList = listOf("one", "two", "three")
    val mutableNumbersList = mutableListOf("one", "two", "three")

    println(listOf(1, 5, 3).sum()) // => 9
    println(listOf("a", "b", "cc").sumBy { it.length }) // => 4

    // Set
    // read-only set and mutable set
    val colors = setOf("red", "blue", "yellow")
    val mutableColors = mutableSetOf("red", "blue", "yellow")

    val longerThan3 = colors.filter { it.length > 3 } // => [blue, yellow]
    println(longerThan3)

    // read-only map and mutable map
    // to infix function
    val desserts = hashMapOf("whipped cream" to "cake", "chocolate" to "cookie")
    println(desserts["chocolate"])

    val inventory = mutableMapOf("pancake" to 1)
    inventory.put("cake", 3)
    inventory.remove("pancake")
}