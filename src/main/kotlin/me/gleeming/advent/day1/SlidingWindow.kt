package me.gleeming.advent.day1

import me.gleeming.advent.task.AdventTask
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Sliding Window
 * https://adventofcode.com/2021/day/1#part2
 */
@OptIn(ExperimentalStdlibApi::class)
class SlidingWindow : AdventTask {

    override val name: String
        get() = "Sliding Window"

    override val number: Int
        get() = 2

    override fun run() {
        val reader = BufferedReader(FileReader(File("inputs/day1/SlidingWindow")))
        var inputLine: String?

        val numbers = ArrayList<Int>()
        while (reader.readLine().also { inputLine = it } != null) if(inputLine != null) numbers.add(inputLine!!.toInt())
        reader.close()

        class Window(val a: Int, val b: Int, val c: Int) {
            fun sum(): Int { return a + b +c }
        }

        var lastWindow = Window(0, 0, 0)
        var numberIncreased = 0

        for(c in 1..numbers.size) {
            val nextWindow = Window(lastWindow.b, lastWindow.c, numbers.removeFirst())

            if(lastWindow.a != 0 && nextWindow.sum() > lastWindow.sum()) {
                numberIncreased++
            }

            lastWindow = nextWindow
        }

        println("[Advent] The amount of windows that increased is $numberIncreased.")
    }
}