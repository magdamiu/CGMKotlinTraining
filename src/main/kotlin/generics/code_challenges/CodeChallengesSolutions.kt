package generics.code_challenges

// cc1
fun copy(from: Array<out Any>, to: Array<Any?>) {
    if (from.size == to.size) {
        for (i in from.indices)
            to[i] = from[i]
    }
}

fun <T> copyV2(from: Array<T>, to: Array<in T>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun <T> copyV3(subtypes: Array<T>, superTypes: Array<in T>) =
    subtypes.forEachIndexed { index, u -> superTypes[index] = u }

// cc2 (start projection)
fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}

fun <T> printGeneric1(values: Array<T>) =
    values.forEach { println(it.toString()) }

fun printAll1(elements: Array<Any?>) = elements.forEach { println(it) }


fun <T, U : T> copy1(subtypes: Array<U>, superTypes: Array<T>) =
    subtypes.forEachIndexed { index, u -> superTypes[index] == u }

fun <T> printGeneric(values: Array<T>) =
    values.forEach { println(it.toString()) }

fun printAll(elements: Array<Any?>) = elements.forEach { println(it) }

// CC3

fun <T : Comparable<T>> greaterThanV1(list: List<T>, threshold: T) =
    list.filter { it > threshold }

fun <T : Comparable<T>> List<T>.biggerThan(comparator: T) =
    this.forEach {
        if (it > comparator)
            println(it)
    }

fun <T> greatherThan(list: List<T>, value: T): List<T> where T : Comparable<T> =
    list.filter { it > value }

fun <T : Comparable<T>> List<T>.greaterThan(threshold: T) = filter { it.compareTo(threshold) > 0 }
fun <T> printGreaterThan(list: List<T>, treshold: T) where T : Comparable<T> = list.filter { it > treshold }

fun main() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any: Array<Any?> = arrayOfNulls(3)

    copyV3(ints, any)
    for (anyElement in any.indices)
        println(anyElement)

    // ###
    val array = arrayOf(1, 2, 3)
    val secondArray = arrayOf("kotlin", 6, 2.3)

    printGeneric(array)
    /*When using the star projection reference type, we can read values from it, but we cannot write them because it will cause a compilation error.*/
}