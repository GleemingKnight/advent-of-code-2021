package me.gleeming.advent.day.two

import me.gleeming.advent.task.AdventTask

class Dive2 : AdventTask() {
    override val name: String
        get() = "Dive! Part 2"

    override val number: Int
        get() = 2

    override fun run() {
        val lines = readInput()

        var horizontalPosition = 0
        var verticalPosition = 0
        var aim = 0

        lines.forEach {
            val split = it.split(" ")
            val value = split[1].toInt()
            when(split[0]) {
                "up" -> aim -= value
                "down" -> aim += value

                "forward" -> {
                    horizontalPosition += value
                    verticalPosition += value * aim
                }
            }
        }

        println("[Advent] Your total travel distance is ${horizontalPosition * verticalPosition}.")
    }
}