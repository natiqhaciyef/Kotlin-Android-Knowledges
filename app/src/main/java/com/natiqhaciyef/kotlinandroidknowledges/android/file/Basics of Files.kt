package com.natiqhaciyef.kotlinandroidknowledges.android.file

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.system.measureTimeMillis

fun main() {
    val file = File("Empty.txt")

    // Creating file
    file.createNewFile()

    // Insert data
    file.writeText("Additional Data")


    val file2 = File("folder/dsa")

    /***
     * When we create folder -> "folder/dsa/algorithm.txt" it returns error because first of all, file2
     * checks "folder/dsa" folder is exists. If not it returns error because it wouldn't find this folder
     * to create an "algorithm.txt" file
     *
     * So eliminating errors we check file path is exists or not. If does not exists then we create
     * this paths first then implement file in it.
     */
    if (!file2.exists()) {
        file2.mkdirs()
    }

    file2.createNewFile()


    // Will print all files in current folder
    val folder = File(".")
    folder.listFiles()?.forEach {
        println(it.name)
    }


    // File Input Streams
    val fileTxt = File("Empty.txt")
    val fileInputStream = FileInputStream(fileTxt)

    // Manual way (risky)
    val bytes = fileInputStream.readBytes()
    fileInputStream.close()


    // It will automatically closes
    FileInputStream(fileTxt).use {
        it.readBytes()
    }

    // converts to string
    println(bytes.decodeToString())


    // Output stream
    outputProcessOnFile(fileTxt, "Hello world! This is ANDRO")
    inputProcessOnFile(fileTxt)
}

fun inputProcessOnFile(file: File) {

    // Manually reading from file
    val strBuilder = StringBuilder()
    val timer1 = measureTimeMillis {
        FileInputStream(file).use {
            var byte = it.read()

            while (byte == -1) {
                strBuilder.append(byte.toChar())
                byte = it.read()
            }
        }
    }


    // Optimal with Buffer reader
    val strBuilder2 = StringBuilder()
    val timer2 = measureTimeMillis {
        FileInputStream(file).bufferedReader().use {
            var byte = it.read()

            while (byte == -1) {
                strBuilder2.append(byte.toChar())
                byte = it.read()
            }
        }
    }

    println("String builder 1: $strBuilder - $timer1 milliseconds")
    println("String builder 2: $strBuilder2 - $timer2 milliseconds")
}

fun outputProcessOnFile(file: File, content: String) {
    val bytes = content.encodeToByteArray()
    // Manually writing from file
    FileOutputStream(file).use { outputStream ->
        for (byte in bytes){
            outputStream.write(byte.toInt())
        }
    }
}