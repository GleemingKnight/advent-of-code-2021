package me.gleeming.advent.day.four

import me.gleeming.advent.task.AdventTask
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

@OptIn(ExperimentalStdlibApi::class)
class GiantSquid : AdventTask() {
    override val name: String
        get() = "Giant Squid"

    override val number: Int
        get() = 1

    override fun run() {
        val lines = readInput()
        val numbers = lines[0].split(",").map { it.toInt() }

        lines.removeFirst()
        lines.removeFirst()

        // Kotlin pair util but with mutable properties
        data class Pair<out A, out B>(
            var first: @UnsafeVariance A,
            var second: @UnsafeVariance B
        )

        val boards = ArrayList<HashMap<Int, List<Pair<Int, Boolean>>>>()

        for(c in 0..lines.size step 6) {
            val board = HashMap<Int, List<Pair<Int, Boolean>>>()

            for(index in 0..4) {
                val pairList = ArrayList<Pair<Int, Boolean>>()
                ArrayList<String>(lines[c + index].split(" ")).forEach { if(it.isNotEmpty()) pairList.add(Pair(it.toInt(), false)) }
                board[index] = pairList
            }

            boards.add(board)
        }

        // Checks if a board can win
        fun canWin(board: HashMap<Int, List<Pair<Int, Boolean>>>): Boolean {
            board.values.forEach { row ->
                var has = true
                row.forEach { if(!it.second) has = false }
                if(has) return true
            }

            for(c in 0 until board.values.size) {
                var has = true

                for(x in 0 until 5) {
                    if(!board[x]!![c].second) has = false
                }

                if(has) return true
            }

            return false
        }

        numbers.forEach { number ->
            boards.forEach { board ->
                board.values.forEach { row ->
                    row.forEach { spot -> if(spot.first == number) spot.second = true }
                }

                if(canWin(board)) {
                    var sum = 0
                    board.values.forEach { row ->
                        row.forEach { spot -> if(!spot.second) sum += spot.first }
                    }

                    println("[Advent] A board has won with a final score of ${sum * number}")
                    return
                }
            }
        }
    }
}