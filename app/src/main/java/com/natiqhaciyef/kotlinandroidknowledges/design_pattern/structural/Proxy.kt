package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.structural

interface Image { fun display() }

class RealImage(private val fileName: String) : Image {
    override fun display() {
        println("Loading image from file $fileName...")
        Thread.sleep(2000)
        println("Image loaded and displayed!")
    }
}

class ProxyImage(private val fileName: String) : Image {
    private var realImage: RealImage? = null

    override fun display() {
        if (realImage == null) { realImage = RealImage(fileName) }
        realImage!!.display()
    }
}

fun main() {
    val image1 = ProxyImage("large_image.jpg")
    val image2 = ProxyImage("large_image.jpg") // Same file, will use cached proxy

    image1.display() // Loads the image
    image2.display() // Uses the cached image, no loading needed
}

