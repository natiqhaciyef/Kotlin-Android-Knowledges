package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

interface Switch {
    var appliance: Appliance
    fun turnOn()
}

interface Appliance { fun run() }

class RemoteControl(override var appliance: Appliance) : Switch {
    override fun turnOn() = appliance.run()
}


class TV : Appliance { override fun run() = println("TV turned on") }

class VacuumCleaner : Appliance { override fun run() = println("VacuumCleaner turned on") }


fun main() {
    val tvRemoteControl = RemoteControl(appliance = TV())
    tvRemoteControl.turnOn()

    val fancyVacuumCleanerRemoteControl = RemoteControl(appliance = VacuumCleaner())
    fancyVacuumCleanerRemoteControl.turnOn()
}
