package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

// Component
interface Employee { fun showDetails(): String }

// Leaf
class Developer(private val name: String, private val position: String) : Employee {
    override fun showDetails() = "Developer: $name, Position: $position"
}

// Composite
class Manager(private val name: String, private val position: String) : Employee {
    private val employees: MutableList<Employee> = mutableListOf()
    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }
    fun removeEmployee(employee: Employee) {
        employees.remove(employee)
    }
    override fun showDetails(): String {
        val employeeDetails = employees.joinToString("\n") { it.showDetails() }
        return "Manager: $name, Position: $position\n$employeeDetails"
    }
}

fun main() {
    val dev1 = Developer("John Doe", "Frontend Developer")
    val dev2 = Developer("Jane Smith", "Backend Developer")
    val dev3 = Developer("Natig Hajiyev", "Android Developer")
    val manager = Manager("Ella White", "Tech Lead")

    manager.addEmployee(dev1)
    manager.addEmployee(dev2)
    manager.addEmployee(dev3)
    println(manager.showDetails())
}