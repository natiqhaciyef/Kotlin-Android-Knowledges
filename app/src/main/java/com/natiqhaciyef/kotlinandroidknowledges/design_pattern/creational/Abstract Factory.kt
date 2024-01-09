package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.creational

// variants as enum
enum class FactoryVariant {
    WindowsUI,
    LinuxUI
}

// Abstract factory for UI elements
interface UIFactory {
    fun createButton(): Button
    fun createScrollbar(): Scrollbar

    companion object{
        fun getFactory(whichOne: Int): UIFactory {
            return when (whichOne) {
                1 -> WindowsUIFactory()
                2 -> LinuxUIFactory()
                else -> throw IllegalArgumentException("value: $whichOne is not available")
            }
        }

        fun getFactory(whichOne: FactoryVariant): UIFactory {
            return when (whichOne) {
                FactoryVariant.WindowsUI -> WindowsUIFactory()
                FactoryVariant.LinuxUI -> LinuxUIFactory()
                else -> throw IllegalArgumentException("value: $whichOne is not available")
            }
        }
    }
}

// Concrete UI elements (interfaces for abstraction)
interface Button {
    fun click()
    fun display()
}

interface Scrollbar {
    fun moveUp()
    fun moveDown()
    fun display()
}

// Concrete factories for different UI themes
class WindowsUIFactory : UIFactory {
    override fun createButton(): Button = WindowsButton()
    override fun createScrollbar(): Scrollbar = WindowsScrollbar()
}

class LinuxUIFactory : UIFactory {
    override fun createButton(): Button = LinuxButton()
    override fun createScrollbar(): Scrollbar = LinuxScrollbar()
}

// Concrete UI elements for different platforms
class WindowsButton : Button {
    override fun click() {
        println("Windows button clicked")
    }
    override fun display() {
        println("Displaying Windows button")
    }
}

class LinuxButton : Button {
    override fun click() {
        println("Linux button clicked")
    }
    override fun display() {
        println("Displaying Linux button")
    }
}

class WindowsScrollbar : Scrollbar {
    override fun moveUp() {
        println("Windows scrollbar moved up")
    }
    override fun moveDown() {
        println("Windows scrollbar moved down")
    }
    override fun display() {
        println("Displaying Windows scrollbar")
    }
}

class LinuxScrollbar : Scrollbar {
    override fun moveUp() {
        println("Linux scrollbar moved up")
    }
    override fun moveDown() {
        println("Linux scrollbar moved down")
    }
    override fun display() {
        println("Displaying Linux scrollbar")
    }
}


// Client code
fun main() {
    val factory = UIFactory.getFactory(FactoryVariant.WindowsUI)

    val button = factory.createButton()
    val scrollbar = factory.createScrollbar()

    button.click()
    scrollbar.moveUp()
    button.display()
    scrollbar.display()
}
