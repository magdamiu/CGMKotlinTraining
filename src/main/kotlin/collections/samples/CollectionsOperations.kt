package collections.samples

class Language(val name: String, var releaseYear: Int = 2020) {
    val company = "JetBrains"
    var town = "Saint Petersburg"
}

fun main() {
    //input data
    var kotlin = Language("kotlin")
    var java = Language("java")
    java.town = "San Francisco"
    var php = Language("php")
    var scala = Language("scala")
    scala.town = "New York"
    var javascript = Language("javascript")

    var languagesList = listOf(kotlin, java, php, scala, javascript)

    println("---aggregateFunctions---")
    aggregateFunctions(languagesList)

    println("---searchFunctions---")
    searchFunctions(languagesList)

    println("---filterFunctions---")
    filterFunctions(languagesList)

    println("---transformFunctions---")
    transformFunctions(languagesList)
}

fun aggregateFunctions(languagesList: List<Language>) {
    // count
    println(languagesList.count())

    //maxBy
    println(languagesList.maxByOrNull { it.name.length })

    //minBy
    println(languagesList.minByOrNull { it.name.length })

    //average
    println(arrayOf(8, 8, 10, 9, 9).average())

    //sum
    println(arrayOf(7.3, 7.6, 7.4, 7.6, 8.1, 7.7).sum())
    println(languagesList.sumBy { it.releaseYear })
}

fun searchFunctions(languagesList: List<Language>) {
    //first
    //NoSuchElementException could be thrown
    println(languagesList.first())
    println(languagesList.first { it.name.length == 3 })
    println(languagesList.firstOrNull { it.name.length == 2 })

    //find
    println(languagesList.find { it.town.equals("San Francisco") })
    println(languagesList.findLast { it.town.equals("Bucharest") })

    //last
    println(languagesList.last())
    println(languagesList.last { it.town.contains(' ') })

    //single
    //IllegalArgumentException if list has more than one element
    println(languagesList.single { it.town.equals("San Francisco") })
    println(languagesList.singleOrNull { it.town.equals("Pitesti") })
}

fun filterFunctions(languagesList: List<Language>) {
    //filter
    println(languagesList.filter { it.name.contains('k') })

    //filterNot(), filterNotNull()
    println(languagesList.filterNot { it.name.contains('k') })
    println(languagesList.filterNotNull())

    //filterTo(), filterNotTo()
    var listToFilterInto = mutableListOf<Language>()
    languagesList.filterTo(listToFilterInto) { it.town.contains('o') }
    languagesList.filterNotTo(listToFilterInto) { it.town.contains('o') }
    languagesList.filterNotNullTo(listToFilterInto)

    //filterIndexed()
    println(languagesList.filterIndexed { index, _ -> index % 3 == 0 })
}

fun transformFunctions(languagesList: List<Language>) {
    //map
    println(languagesList.map { it.town })
    println(languagesList.mapIndexed { index, language -> index to language.town })

    //distinct
    println(languagesList.map { it.town }.distinct())

    //associate(), associateBy()
    println(languagesList.associate { it.name to it.town })
    println(languagesList.associateBy({ it.name }, { it.company }))

    //groupBy()
    println(languagesList.groupBy { it.company })
}