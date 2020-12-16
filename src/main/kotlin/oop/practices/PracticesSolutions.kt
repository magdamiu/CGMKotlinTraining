package oop.practices

import javax.print.attribute.standard.Destination

// specs https://docs.google.com/document/d/1n9FCO77plodMcwCzEOPRpFZ0-0zl_gqbCjEPzO9Pr8c/edit#

// Practice 1
data class Point2D(var x: Double, var y: Double)

// Practice 2
class Box(var height: Double, var width: Double, var length: Double) {
    fun getVolumeV1(): Double {
        return height * width * length
    }

    fun getVolumeV2() = height * width * length
}

// Practice 3
open class Animal(val sound: String = "???")
class Cat : Animal(sound = "meow")
class Dog : Animal(sound = "woof")

// Practice 4
abstract class Shape {
    abstract fun draw()
    abstract fun erase()
}

class Circle : Shape() {
    override fun draw() {
        println("Draw Circle")
    }

    override fun erase() {
        println("Erase Circle")
    }
}

class Square : Shape() {
    override fun draw() {
        println("Draw Square")
    }

    override fun erase() {
        println("Erase Square")
    }
}

class Triangle : Shape() {
    override fun draw() {
        println("Draw Triangle")
    }

    override fun erase() {
        println("Erase Triangle")
    }
}

// Practice 5
enum class Currency(val currency: String) {
    USD("United States dollar"),
    EUR("Euro"),
    RON("Lei"),
}

// Practice 6
data class AirlineTicket(
    val firstName: String,
    val lastName: String,
    val ticket: Int,
    val origin: String,
    val destination: String
)

// Practice 7
fun AirlineTicket.transferTicket(
    otherFirstName: String,
    otherLastName: String
): AirlineTicket {
    return this.copy(firstName = otherFirstName, lastName = otherLastName)
}

// Practice 8
class Player(val id: Int, val name: String) {
    companion object {
        var role = "playable character"
    }
    fun getInfo() = "$id, $name, $role"
}

fun getPlayerInfo(player: Player) = player.getInfo()


fun main() {
    val shapes = listOf(
        Circle(),
        Square(),
        Triangle()
    )

    shapes.forEach { it.draw() }
    shapes.forEach { it.erase() }
}
