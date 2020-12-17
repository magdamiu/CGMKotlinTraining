package generics.samples

open class Employee(private val name: String) {
    override fun toString(): String {
        return name
    }
}

class Developer(name: String) : Employee(name)
class Tester(name: String) : Employee(name)

fun copyFromTo(from: Array<out Employee>, to: Array<Employee>) {
/*    from[0] = Employee() // compilation error
    from.set(1, to[1]) // compilation error*/

    if(from.size == to.size) {
        for (i in 0 until from.size) {
            to[i] = from[i]
        }
    }
}

// type param restriction
class Gift<T : Employee>(val employee: Employee, val money: Double)

fun evaluate(gift: Gift<out Employee>) {
    val employee: Employee = gift.employee
    println(employee)
}

fun <T> printList(list: List<T>) {
    if(list is List<*>) {
        println("it's a list")
    }
}

inline fun <reified T> erased(list: List<Any>) {
    if(list is T) {

    }
}


fun main() {
    val employee1: Employee = Developer("Clara")
    val employee2: Employee = Tester("John")

    var leadDeveloper: Developer? = Developer("Julie")
    leadDeveloper = null
    // var newEngManager: Developer = leadDeveloper


    val employees = Array<Employee>(3) {_ -> Employee("July")}
    val testers = Array<Tester> (3) { _ -> Tester("Stacy") }
    copyFromTo(testers, employees)


    val developerTracy = Developer("Tracy")
    val testerJames = Tester("Stuart")

    val giftTracy: Gift<Employee> = Gift(employee = developerTracy, money = 250.0)
    val giftJames: Gift<Tester> = Gift(employee = testerJames, money = 325.0)

    evaluate(giftTracy)
    evaluate(giftJames)

    val listOfString = listOf("Red", "Green", "Pink")
    val listOfInt = listOf(1, 2, 3)
}
