package me.gleeming.advent.task

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

abstract class AdventTask {
    /**
     * Name of the task
     */
    abstract val name: String

    /**
     * Number of the task
     */
    abstract val number: Int

    /**
     * Runs the program for the given day
     */
    abstract fun run()

    /**
     * Reads the input from the file
     */
    fun readInput(): ArrayList<String> {
        val reader = BufferedReader(FileReader(File("inputs/$name")))
        var inputLine: String?

        val lines = ArrayList<String>()
        while (reader.readLine().also { inputLine = it } != null) if(inputLine != null) lines.add(inputLine!!)
        reader.close()

        return lines
    }
}