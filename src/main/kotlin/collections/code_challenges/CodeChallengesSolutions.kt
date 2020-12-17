package collections.code_challenges

// CC1
fun MutableList<Int>.addToList(value: Int): MutableList<Int> {
    this.add(value)
    return this
}

fun List<Int>.addElement(newValue: Int) = this + newValue

fun addOneElem(original: List<Int>, newNr: Int): List<Int> = original.plus(newNr)

fun addInteger(list: MutableList<Int>, value: Int): MutableList<Int> {
    list.add(value)
    return list
}

fun addValue(integers: MutableList<Int>, newValue: Int): MutableList<Int> {
    integers += newValue
    return integers
}

// CC2
fun MutableList<String>.replace(toReplace: String): MutableList<String> {
    this.replaceAll { if (it == toReplace) "kotlin" else it }
    return this
}

fun replaceString(list: MutableList<String>, value: String) = list.map { it.replace(value, "Kotlin") }

fun replaceStringV2(text: MutableList<String>, toReplace: String): String {
    text.replaceAll { if (it == toReplace) "Kotlin" else it }
    return text.joinToString(" ")
}

fun MutableList<String>.replaceStringV3(replaceThisString: String): List<String> =
    this.map { element ->
        element.replace(replaceThisString, "Kotlin", true)
    }

fun String.doKotlinOnly(verb: String) = this.split(" ").joinToString(" ") { if (it == verb) "kotlin" else it }

fun changeTo(phrase: MutableList<String>, stringValue: String): List<String> =
    phrase.map { if (it == stringValue) "Kotlin" else it }

fun MutableList<String>.replaceWithKotlin(search: String) = map { if (it == search) "Kotlin" else it }

fun replaceStringV4(listItems: List<String>, stringToReplace: String): List<String> {
    return listItems
        .map {
            when (it == stringToReplace) {
                true -> "Kotlin"
                false -> it
            }
        }
}

fun MutableList<String>.takePlace(value: String): MutableList<String> {
    for (index in this.indices) {
        if (this[index] == value) {
            this[index] = "kotlin"
        }
    }
    return this
}

fun replaceV5(list: MutableList<String>, toReplace: String) =
    list.map { if (it == toReplace) "Kotlin" else it }


// CC3
fun Set<String>.containsAll(arr: Array<String>): Boolean {
    arr.asSequence().forEach { if (!this.contains(it)) return false }
    return true
}

fun <T> Array<T>.containAll(set: Set<T>) = all { set.contains(it) }

fun checkAll(set: Set<String>, array: Array<String>) =
    set.containsAll(array.toList())

fun Set<String>.containsAllElements(list: MutableList<String>) = this.containsAll(list)

fun HashSet<String>.allStringsArePresent(array: Array<String>): Boolean =
    this.containsAll(array.toList())

fun checkSetAndArray(set: Set<String>, array: Array<String>) = set.containsAll(array.asSequence().toList())

fun Set<String>.containsall(stringArray: Array<String>): Boolean {
    return this.containsAll(stringArray.toList())
}

fun isInSet(theSet: Set<String>, theArray: Array<String>): Boolean =
    theSet.containsAll(theArray.toList())

fun Array<String>.matchSet(set: Set<String>): Boolean {
    var result = !this.isEmpty()
    set.forEach { result = result && this.contains(it) }
    return result
}

// CC4

fun oddWithouuth1() = generateSequence(3, { it + 2 })
fun oddWithout1(): Int {
    return generateSequence(3, { it + 2 })
        .filterNot { it.toString().contains("1") }
        .take(20)
        .sum()
}

fun generateSequence(): List<Int> {
    return generateSequence(3) { it + 2 }
        // remove the line from below for infinite elements
        .take(20)
        .filter { !it.toString().contains("1") }
        .toList()
}

// CC5
fun fibonacci(): Sequence<Int> {
    val computed = mutableListOf(0, 1)
    val compute = { pos: Int ->
        computed += computed[pos - 1] + computed[pos - 2]
        computed[pos]
    }

    return generateSequence(0) { it + 1 }
        .map { computed.getOrNull(it) ?: compute(it) }
}

fun fibonacci1() = generateSequence(Pair(0, 1), { Pair(it.second, it.first + it.second) })
    .take(20)
    .toList()
    .map { it.first }

fun fibonacci2() = generateSequence(Pair(0, 1), { Pair(it.second, it.second + it.first) }).map { it.first }


fun main() {
    // input data and tests for CC1
    val theMutableList: MutableList<Int> = mutableListOf<Int>(8, 11, 13, 14)
    val theSecondMutableList: MutableList<Int> = mutableListOf<Int>(8, 11, 13, 14)
    val theThirdMutableList: MutableList<Int> = mutableListOf<Int>(8, 11, 13, 14)
    theMutableList.addToList(1)

    val theList = listOf(8, 11, 13, 14)
    println(addOneElem(theList, 2))
    println(theList.addElement(2))
    println(addInteger(theSecondMutableList, 2))
    println(addValue(theThirdMutableList, 2))

    // input data and tests for CC2
    val words = listOf<String>("Sometimes", " you ", "have ", "to ", "shake ", "up ", "your ", "life")
    val mutableWords = mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life")
    println(mutableWords.replace("shake"))
    println(replaceString(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life"), "shake"))
    println(replaceStringV2(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life"), "shake"))
    println(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life").replaceStringV3("shake"))
    println("Sometimes you have to Kotlin up your life".doKotlinOnly("shake"))
    println(changeTo(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life"), "shake"))
    println(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life").replaceWithKotlin("shake"))
    println(replaceStringV4(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life"), "shake"))
    println(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life").takePlace("shake"))
    println(replaceV5(mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life"), "shake"))


    // input data for tests for CC3
    println("\nchallenge 3")
    fun Array<String>.allIn(set: Set<String>): Boolean =
        this.map { set.contains(it) }.all { it }

    val someWords = arrayOf<String>("it\'s", "not", "done", "when", "it\'s", "done")
    val setOfWords = setOf<String>("it\'s", "not", "done", "when")

    println(someWords.allIn(setOfWords))
    println(setOfWords.containsAll(someWords))
    println(someWords.containAll(setOfWords))
    println(setOfWords.containsAllElements(mutableListOf("it\'s", "not", "done", "when", "it\'s", "done")))
    println(hashSetOf("it\'s", "not", "done", "when").allStringsArePresent(someWords))
    println(setOfWords.containsall(someWords))
    println(isInSet(setOfWords, someWords))
    println(someWords.matchSet(setOfWords))
    println(checkAll(setOfWords, someWords))

    val setString = mutableSetOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life")
    val mutableListOf = mutableListOf("Sometimes", "you", "have", "to", "shake", "up", "your", "life")
    println(setString.containsAll(mutableListOf))

    val secondSetOfWords = mutableSetOf("ciao", "viva", "il", "vino")
    val array = arrayOf("il", "vino")
    println(checkSetAndArray(secondSetOfWords, array))


    // CC4
    val oddNumbers = oddWithouuth1()
    println(oddNumbers.take(20).toList())
    println(oddWithout1())
    println(generateSequence())
    println(generateSequence().sum())


    // CC5
    println("====== fib ======")
    println(fibonacci().take(10).toList())
    println(fibonacci1())
    println(fibonacci2().take(10).toList())
}