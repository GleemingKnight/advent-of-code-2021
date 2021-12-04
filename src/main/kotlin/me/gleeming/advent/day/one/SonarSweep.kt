package me.gleeming.advent.day.one

import me.gleeming.advent.task.AdventTask

class SonarSweep : AdventTask() {

    override val name: String
        get() = "Sonar Sweep"

    override val number: Int
        get() = 1

    override fun run() {
        val numbers = readInput().map { it.toInt() }

        var amountOver = 0
        var lastAmount = -1
        numbers.forEach {
            if (lastAmount == -1) {
                lastAmount = it
                return@forEach
            }

            if (it > lastAmount) {
                amountOver++
            }

            lastAmount = it
        }

        println("There were $amountOver measurements larger than the previous measurement.")
    }
}