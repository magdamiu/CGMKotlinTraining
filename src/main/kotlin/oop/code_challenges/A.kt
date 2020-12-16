package oop.code_challenges

// CC3
interface A {
    fun foo()
    fun bar()
}

interface B {
    fun foo()
    fun baz()
}

class AImpl : A {
    override fun foo() = println("AA.foo()")
    override fun bar() = println("AA.bar()")
}

class BImpl : B {
    override fun foo() = println("BB.foo()")
    override fun baz() = println("BB.baz()")
}

class Delegation(val a: A, val b: B) :
    A by a, B by b {
    override fun foo() {
        a.foo()
        b.foo()
        println("Delegation.foo()")
    }
}

fun main() {
    val d = Delegation(AImpl(), BImpl())
    d.foo()
    println("----")
    d.bar()
    println("----")
    d.baz()
}