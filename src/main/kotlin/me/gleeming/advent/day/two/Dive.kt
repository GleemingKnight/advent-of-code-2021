package me.gleeming.advent.day.two

import me.gleeming.advent.task.AdventTask

class Dive : AdventTask() {
    override val name: String
        get() = "Dive!"

    override val number: Int
        get() = 1

    override fun run() {
        val lines = readInput()

        var horizontalPosition = 0
        var verticalPosition = 0

        lines.forEach {
            val split = it.split(" ")
            val value = split[1].toInt()
            when(split[0]) {
                "forward" -> horizontalPosition += value
                "up" -> verticalPosition -= value
                "down" -> verticalPosition += value
            }
        }

        println("[Advent] Your total travel distance is ${horizontalPosition * verticalPosition}.")
    }
}