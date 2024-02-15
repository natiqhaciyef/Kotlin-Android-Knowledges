package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations

// Creating Annotation
@Target(AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
annotation class AnnotationPrototype(val name: String)

@AnnotationPrototype("Programming languages") class ProgrammingLanguage{
    fun getHistory(){}
    @AnnotationPrototype("Kotlin") val name = ProgrammingLanguage::class.java.annotations
}

@Retention(AnnotationRetention.RUNTIME)
annotation class RequiresParameter


// Labeling
class MathematicalCalculation{
    fun matrixCalculator(){
        loop@ for(element in 0..3){
            for (subElement in 0..3){
                if (subElement > element)
                    break@loop
            }
        }
    }
}

class MyCustomClass(
    @RequiresParameter val data: String,
    val optionalParam: Int? = null
)

fun checkParameters(obj: MyCustomClass) {
    val dataField = MyCustomClass::class.java.getDeclaredField("data")
    val hasDataAnnotation = dataField.getAnnotation(RequiresParameter::class.java) != null
    // Similar check for other potential annotated parameters

    if (hasDataAnnotation) {
        // Do something when data parameter is present
    } else {
        // Do something when data parameter is missing
    }
}


fun main(){
    val kotlin = ProgrammingLanguage::class.java
    for (annotation in kotlin.annotations){
        println(annotation.annotationClass.simpleName)
    }

    println(kotlin.name)
}



// @Target
// @Retention
// @Repeatable
// @MustBeDocumented