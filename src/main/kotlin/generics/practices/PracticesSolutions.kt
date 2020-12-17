package generics.practices

// P1
fun <T> List<T>.secondOrNull(): T? = getOrNull(1)
fun <T> List<T>.secondOrNullV2(): T? = this[1]

fun <T> List<T>.penultimateOrNull(): T? = this[this.size - 2]
fun <T> List<T>.penultimateOrNullV2(): T? = getOrNull(size - 2)

// P2
fun <T> List<T>.reversed(): List<T> {
    var result = mutableListOf<T>()
    for (i in lastIndex downTo 0) {
        result.add(get(i))
    }
    return result
}

// T is from type
// E is from element

// P3
class CountingSet<E> {
    private val map = mutableMapOf<E, Int>()

    fun add(element: E) {
        map[element] = (map[element] ?: 0) + 1
    }

    fun addV2(element: E) {
        map.compute(element) { key, count -> count?.inc() ?: 1 }
    }

    fun count(element: E): Int {
        return map[element] ?: 0
    }

    fun toSet(): Set<E> = map.keys
}

fun <T> getWhenGrater(list: List<T>, threshold: T): List<T>
        where T : Comparable<T>{
    return list.filter { it > threshold }.map { it }
}

fun main() {
    val cs = CountingSet<String>()
    cs.add("abc")
    cs.add("abc")
    cs.add("def")
    println(cs.count("abc")) // 2
    println(cs.count("def")) // 1
    println(cs.count("xyz")) // 0
}