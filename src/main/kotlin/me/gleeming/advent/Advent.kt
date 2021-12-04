package me.gleeming.advent

import me.gleeming.advent.day.four.GiantSquid
import me.gleeming.advent.day.four.GiantSquid2
import me.gleeming.advent.day.one.SonarSweep2
import me.gleeming.advent.day.one.SonarSweep
import me.gleeming.advent.day.three.BinaryDiagnostics
import me.gleeming.advent.day.three.BinaryDiagnostics2
import me.gleeming.advent.day.two.Dive
import me.gleeming.advent.day.two.Dive2
import me.gleeming.advent.task.AdventTask
import java.util.*
import kotlin.collections.HashMap

/**
 * Main function of the program
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val days = getDays()

    // Has the user run a task
    fun runTask() {
        // Has the user choose a day to run the task from
        fun chooseDay(): Int {
            println(" ")
            println("[Advent] Please enter a day to run a task from. (1-${days.keys.size})")

            val day = scanner.nextLine().toIntOrNull()
            if(day == null || day < 1 || day > 25) {
                println("[Advent] The value you entered is not a valid day.")
                return chooseDay()
            }


            if(!days.containsKey(day)) {
                println("[Advent] No tasks found for the day '$day' have been completed yet.")
                return chooseDay()
            }

            return day
        }

        val day = chooseDay()

        // Has the user choose a task to run
        fun chooseTask(): AdventTask {
            println("[Advent] Please choose a task to run:")

            val tasks = days[day]!!
            tasks.forEach {
                println("(${it.number}) ${it.name}")
            }

            val taskId = scanner.nextLine().toIntOrNull()
            if(taskId == null) {
                println("[Advent] The value you entered is not a valid task.")
                return chooseTask()
            }

            val task = tasks.find { it.number == taskId }
            if(task == null) {
                println("[Advent] Failed to find the task by the number of '$taskId'")
                return chooseTask()
            }

            return task
        }

        chooseTask().run()
        runTask()
    }

    runTask()
}

/**
 * Gets the days for the advent program
 */
fun getDays(): HashMap<Int, List<AdventTask>> {
    val dayMap = HashMap<Int, List<AdventTask>>()

    dayMap[1] = listOf(
        SonarSweep(),
        SonarSweep2()
    )

    dayMap[2] = listOf(
        Dive(),
        Dive2()
    )

    dayMap[3] = listOf(
        BinaryDiagnostics(),
        BinaryDiagnostics2()
    )

    dayMap[4] = listOf(
        GiantSquid(),
        GiantSquid2()
    )

    return dayMap
}