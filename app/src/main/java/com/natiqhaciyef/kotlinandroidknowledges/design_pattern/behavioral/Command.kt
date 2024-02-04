package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface Command { fun execute() }

class Light {
    fun on() { println("Light is on") }

    fun off() { println("Light is off") }
}


class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.on()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.off()
    }
}

class RemoteControl {
    private val onCommands = mutableMapOf<Int, Command>()
    private val offCommands = mutableMapOf<Int, Command>()

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonPressed(slot: Int) {
        onCommands[slot]?.execute()
    }

    fun offButtonPressed(slot: Int) {
        offCommands[slot]?.execute()
    }
}


fun main() {
    val light = Light()
    val remoteControl = RemoteControl()

    remoteControl.setCommand(0, LightOnCommand(light), LightOffCommand(light))

    remoteControl.onButtonPressed(0)  // Turns the light on
    remoteControl.offButtonPressed(0) // Turns the light off
}

