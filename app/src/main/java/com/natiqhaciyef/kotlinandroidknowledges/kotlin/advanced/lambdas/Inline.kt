package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.lambdas


data class Animal(val name: String)

fun main() {
    val animal1 = Animal("Bat")
    val animal2 = Animal("Tiger")

    // CPU time processing and to lighten up memory for lambda (hard way). And that's why, using
    // inline functions
    myWithAnimal(animal2.name, object : Function1<String, Unit>{
        override fun invoke(name: String){
            name.capitalize()
        }
    })

    // Inline - CPU time processing and do not memorize function body. It makes light apps
    myWithAnimalInline(animal1.name){
        uppercase()
    }
}

fun myWithAnimal(name: String, block: String.() -> Unit){
    name.block()
}

inline fun myWithAnimalInline(name: String, block: String.() -> Unit) {
    name.block()
}
