package oop.code_challenges;

// CC4
interface BoardGame {
    fun move(): Boolean

    companion object {
        fun createBoard() {
            println("BoardGame.createBoard()")
        }
    }
}

interface GameFactory {
    fun create(): BoardGame
}

class Checkers private constructor() : BoardGame {
    private var moves = 0
    override fun move(): Boolean {
        println("Checkers move $moves")
        return ++moves != max
    }

    companion object Factory : GameFactory {
        private const val max = 3

        init {
            BoardGame.createBoard()
        }

        override fun create() = Checkers()
    }
}

class Chess private constructor() : BoardGame {
    private var moves = 0
    override fun move(): Boolean {
        println("Chess move $moves")
        return ++moves != max
    }

    companion object Factory : GameFactory {
        private const val max = 4

        init {
            BoardGame.createBoard()
        }

        override fun create() = Chess()
    }
}

fun playGame(factory: GameFactory) {
    val s = factory.create()
    while (s.move())
    ;
}

fun main() {
    playGame(Checkers.Factory)
    playGame(Chess.Factory)
}