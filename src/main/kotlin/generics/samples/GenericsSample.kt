package generics.samples

fun <T> findFirst(team: List<Employee>, ofClass: Class<T>): T {
    val selected = team.filter { employee -> ofClass.isInstance(employee) }
    if (selected.size == 0) {
        throw RuntimeException("not found")
    }
    return ofClass.cast(selected[0])
}

inline fun <reified T> findFirstReified(team: List<Employee>): T {
    val selected = team.filter { employee -> employee is T }
    if (selected.size == 0) {
        throw RuntimeException("not found")
    }
    return selected[0] as T
}


fun main() {
    val projectTeam = listOf(Developer("Maria"), Tester("Mark"), Developer("Paul"))
}