package me.gleeming.advent.day1

import me.gleeming.advent.task.AdventTask
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Sonar Sweep
 * https://adventofcode.com/2021/day/1
 */
class SonarSweep : AdventTask {

    override val name: String
        get() = "Sonar Sweep"

    override val number: Int
        get() = 1

    override fun run() {
        val reader = BufferedReader(FileReader(File("inputs/day1/SonarSweep")))
        var inputLine: String?

        val numbers = ArrayList<Int>()
        while (reader.readLine().also { inputLine = it } != null) if(inputLine != null) numbers.add(inputLine!!.toInt())
        reader.close()

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