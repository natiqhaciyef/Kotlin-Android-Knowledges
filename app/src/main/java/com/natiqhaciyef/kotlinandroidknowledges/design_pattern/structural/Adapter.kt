package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

// Target interface that the client expects
interface Printer {
    fun print()
}

// Adaptee (the class to be adapted)
class ModernPrinter {
    fun startPrint() {
        println("Printing in a modern way")
    }
}

// Class-based Adapter
class ModernPrinterAdapter(private val modernPrinter: ModernPrinter) : Printer {
    override fun print() {
        modernPrinter.startPrint()
    }
}

// Client code
fun main() {
    val modernPrinter = ModernPrinter()
    val legacyPrinter: Printer = ModernPrinterAdapter(modernPrinter)

    legacyPrinter.print()
}