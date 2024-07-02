package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation


/**
 * @Target annotation specifies the possible kinds of elements which can be annotated with the annotation
 * (such as classes, functions, properties, and expressions);
 * */
@Target(AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
annotation class TargetAnnotationPrototype(val name: String)

/**
 * @Retention specifies whether the annotation is stored in the compiled class files and whether
 * it's visible through reflection at runtime (by default, both are true);
 * */
@Retention(AnnotationRetention.RUNTIME) // Annotation will be available at runtime
annotation class Loggable(val metadata: String)

@Target(
    AnnotationTarget.PROPERTY,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.TYPE_PARAMETER,
)
@Retention(AnnotationRetention.RUNTIME) // Annotation will be available at runtime
annotation class CustomField


/**
 * @Repeatable allows using the same annotation on a single element multiple times;
 */
@Repeatable
annotation class Permission(val permissionTitle: String)

@TargetAnnotationPrototype("Target Prototype")
annotation class PermissionList(val params: Array<Permission>)


/**
 * @MustBeDocumented specifies that the annotation is part of the public API and should be included in the
 * class or method signature shown in the generated API documentation.
 */
@MustBeDocumented
annotation class MustBeDocumentedAnnotation


@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FIELD) // Specify target as field
annotation class NotNullExample

@TargetAnnotationPrototype("Programming languages")
class ProgrammingLanguage {

    @TargetAnnotationPrototype("Kotlin")
    val name: Array<Annotation> = ProgrammingLanguage::class.java.annotations
}


@Loggable("Runtime")
@PermissionList(
    params = [Permission("CAMERA"),
        Permission("READ_EXTERNAL_STORAGE")]
)
class MyCustomClass(
    val data: String,
    @CustomField
    val optionalParam: Int = 0,
){

    fun optionalParamContainer(@CustomField param: String): String{
        return param
    }
}


fun main() {
    val myClas = MyCustomClass("Pick", 10)

    println(checkParametersJava(myClas))
//    println(myClas.optionalParamContainer())
    println(checkParametersOfData(myClas))
}

fun checkParametersJava(obj: MyCustomClass): Boolean {
    val dataField = obj::class.java
    return dataField.getAnnotation(Loggable::class.java) != null
}

fun checkParametersKotlin(obj: MyCustomClass): Boolean {
    val dataField = obj::class
    return dataField.findAnnotation<Loggable>() != null
}

fun checkParametersOfData(myCustomClass: MyCustomClass): Boolean {
    val field = myCustomClass::class.declaredFunctions.find { it.name == "optionalParamContainer" }!!
    return field.parameters.any {
        it.name == "param" &&
        it.findAnnotation<CustomField>() != null
    }
}

//    val kotlin = ProgrammingLanguage::class.java
//    for (annotation in kotlin.annotations){
//        println(annotation.annotationClass.simpleName)
//    }
//    println(kotlin.name)
