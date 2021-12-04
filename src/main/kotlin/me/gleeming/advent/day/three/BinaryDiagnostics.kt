package me.gleeming.advent.day.three

import me.gleeming.advent.task.AdventTask
import java.lang.StringBuilder

class BinaryDiagnostics : AdventTask() {
    override val name: String
        get() = "Binary Diagnostics"

    override val number: Int
        get() = 1

    override fun run() {
        val lines = readInput()
        val map = HashMap<Int, HashMap<Int, Int>>()

        lines.forEach {
            val split = it.split("").filter { line -> line != "" }
            for(c in split.indices) {
                var pairMap = map[split[c].toInt()]
                if(pairMap == null) pairMap = HashMap()

                var currentValue = pairMap[c]
                if(currentValue == null) currentValue = 0

                pairMap[c] = currentValue + 1
                map[split[c].toInt()] = pairMap
            }
        }

        val gamaRateBuilder = StringBuilder()
        for(c in 0 until map.values.first().size) {
            if(map[0]?.get(c)!! > map[1]?.get(c)!!) gamaRateBuilder.append(0)
            else gamaRateBuilder.append(1)
        }

        val epsilonRateBuilder = StringBuilder()
        for(c in 0 until map.values.first().size) {
            if(map[0]?.get(c)!! < map[1]?.get(c)!!) epsilonRateBuilder.append(0)
            else epsilonRateBuilder.append(1)
        }

        val gammaRate = Integer.parseInt(gamaRateBuilder.toString(), 2)
        val epsilonRate = Integer.parseInt(epsilonRateBuilder.toString(), 2)

        println("[Advent] The consumption of the submarine is ${gammaRate * epsilonRate}.")
    }
}