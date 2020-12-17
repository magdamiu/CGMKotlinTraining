package collections.practices

// P1
fun sumOfNumbers(numbers: List<Int>): Int {
    return numbers.sum()
}

// P2
fun numberOfOccurances(words: List<String>, word: String): Int {
    return words.filter { it == word }.size
}

fun numberOfOccurancesV2(words: List<String>, word: String): Int {
    return words.count { it == word }
}

// P3
fun productsPositions(products: List<String>, product: String) {
    products.forEachIndexed { index, currentProduct -> if (currentProduct == product) print("$index") }
}


// P4
fun getVowelsIndex(searched: Char ): Int? = mapOf<Char, Int>('a' to 1, 'e' to 5, 'i' to 9, 'o' to 15, 'u' to 21)[searched]
fun getVowelPosOrNull(searched: Char ): Int? =
    mapOf<Char, Int>('a' to 1, 'e' to 5, 'i' to 9, 'o' to 15, 'u' to 21)[searched.toLowerCase()] ?: 0


// P5
fun from(n: Int): Sequence<Int> = generateSequence (n){ it + 1}

fun main() {
    var numbers = listOf<Int>(1, 2, 3)
    println(sumOfNumbers(numbers))

    // P4
    val vowels = "aeiou"
    val letters = mutableMapOf<Char, Int>()
    var pos = 1
    for (index in 'a'..'z') {
        letters[index] = pos++
    }

    val char = readLine()!![0]
    if (vowels.contains(char)) {
        println(letters[char])
    } else {
        println(0)
    }

    val newVowels = mapOf('a' to 1, 'e' to 5, 'i' to 9, 'o' to 15, 'u' to 21)
    val letter = 'a'
    val result = newVowels[letter] ?: 0

    // P5
    val resultOfSequence = from(12).take(4).toList()
    println(resultOfSequence)
}