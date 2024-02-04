package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.creational

class Food private constructor(
    var bread: String = "Flat bread",
    var ingredients: List<String>?,
    var condiments: List<String>?,
    var meat: String?,
    var sous: String?
){

    data class Builder(
        private var bread: String = "Flat bread",
        private var ingredients: List<String>? = null,
        private var condiments: List<String>? = null,
        private var meat: String? = null,
        private var sous: String? = null
    ){

        fun bread(bread: String) = apply { this.bread = bread}
        fun ingredients(ingredients: List<String>) = apply  { this.ingredients = ingredients}
        fun condiments(condiments: List<String>) = apply  { this.condiments = condiments}
        fun meat(meat: String) = apply { this.meat = meat}
        fun sous(sous: String) = apply  { this.sous = sous}

        fun build() = Food(bread, ingredients, condiments, meat, sous)
    }
}

fun main() {
    var food = Food.Builder()
}