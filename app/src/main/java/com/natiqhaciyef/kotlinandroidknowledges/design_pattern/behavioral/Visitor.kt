package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

abstract class Shape {
    abstract fun accept(visitor: ShapeVisitor)
}

interface ShapeVisitor {
    fun visitCircle(circle: Circle)
    fun visitRectangle(rectangle: Rectangle)
    fun visitTriangle(triangle: Triangle)
}

class Circle(
    var radius: Double
) : Shape() {

    override fun accept(visitor: ShapeVisitor) {
        visitor.visitCircle(this)
    }
}

class Rectangle(
    var width: Double,
    var height: Double,
) : Shape() {
    override fun accept(visitor: ShapeVisitor) {
        visitor.visitRectangle(this)
    }
}

class Triangle(
    var base: Double,
    var height: Double,
) : Shape() {

    override fun accept(visitor: ShapeVisitor) {
        visitor.visitTriangle(this)
    }
}

class AreaVisitor : ShapeVisitor {
    var totalArea = 0.0

    override fun visitCircle(circle: Circle) {
        totalArea += Math.PI * circle.radius * circle.radius
    }

    override fun visitRectangle(rectangle: Rectangle) {
        totalArea += rectangle.width * rectangle.height
    }

    override fun visitTriangle(triangle: Triangle) {
        totalArea += 0.5 * triangle.base * triangle.height
    }
}

class PerimeterVisitor : ShapeVisitor {
    var totalPerimeter = 0.0

    override fun visitCircle(circle: Circle) {
        println("Circle visited...")
    }

    override fun visitRectangle(rectangle: Rectangle) {
        println("Rectangle visited...")
    }

    override fun visitTriangle(triangle: Triangle) {
        println("Triangle` visited...")
    }
}

fun main() {
    val shapes = listOf(Circle(5.0), Rectangle(4.0, 6.0), Triangle(3.0, 4.0))

    val areaVisitor = AreaVisitor()
    for (shape in shapes) {
        shape.accept(areaVisitor)
    }
    println("Total area: ${areaVisitor.totalArea}")
}



