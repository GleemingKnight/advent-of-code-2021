package me.gleeming.advent.day.three

import me.gleeming.advent.task.AdventTask
import java.lang.StringBuilder

class BinaryDiagnostics2 : AdventTask() {
    override val name: String
        get() = "Binary Diagnostics"

    override val number: Int
        get() = 2

    override fun run() {
        val numbers = readInput()

        var binaryOxygen = ""
        val oxygenRatingList = numbers.toMutableList()
        for(index in 0 until oxygenRatingList.first().toString().length) {
            val zeros = ArrayList<String>()
            val ones = ArrayList<String>()

            oxygenRatingList.forEach {
                val split = it.split("").filter { string -> string != "" }
                if(split[index].toInt() == 0) zeros.add(it) else ones.add(it)
            }

            if(ones.size >= zeros.size) oxygenRatingList.removeAll(zeros)
            else oxygenRatingList.removeAll(ones)

            if(oxygenRatingList.size == 1) {
                binaryOxygen = oxygenRatingList.first()
                break
            }
        }

        var binaryCarbon = ""
        val carbonRatingList = numbers.toMutableList()
        for(index in 0 until carbonRatingList.first().toString().length) {
            val zeros = ArrayList<String>()
            val ones = ArrayList<String>()

            carbonRatingList.forEach {
                val split = it.split("").filter { string -> string != "" }
                if(split[index].toInt() == 0) zeros.add(it) else ones.add(it)
            }

            if(ones.size < zeros.size) carbonRatingList.removeAll(zeros)
            else carbonRatingList.removeAll(ones)

            if(carbonRatingList.size == 1) {
                binaryCarbon = carbonRatingList.first()
                break
            }
        }

        val oxygen = Integer.parseInt(binaryOxygen, 2)
        val carbon = Integer.parseInt(binaryCarbon, 2)

        println("[Advent] The life support of the submarine is ${oxygen * carbon}.")
    }
}