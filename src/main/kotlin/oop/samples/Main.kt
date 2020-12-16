package oop.samples

// properties
open class Client {
    var name: String = "Kotlin"
        get() = field                     // getter
        set(value) {
            field = value                  // setter
        }

    var age: Int = 18
    val info: String
        get() {
            return "name = $name, age = $age"
        }
}

fun main() {
    var client = Client()
    var theName = client.name // getter
    client.name = "ada" // setter
    println(client.info)
}