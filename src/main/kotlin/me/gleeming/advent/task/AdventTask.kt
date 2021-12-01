package me.gleeming.advent.task

interface AdventTask {
    /**
     * Name of the task
     */
    val name: String

    /**
     * Number of the task
     */
    val number: Int

    /**
     * Runs the program for the given day
     */
    fun run()
}