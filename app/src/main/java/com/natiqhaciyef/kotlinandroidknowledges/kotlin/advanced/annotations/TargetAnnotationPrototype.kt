package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations


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
    @field: NotNullExample
    val optionalParam: Int? = null
)



fun main() {
    val myCustomClass = MyCustomClass::class
//    println(myCustomClass.annotations)

    println("Start")
    val myClas = MyCustomClass("", null)
    println(myClas.optionalParam)
    println("End")


//    val kotlin = ProgrammingLanguage::class.java
//    for (annotation in kotlin.annotations){
//        println(annotation.annotationClass.simpleName)
//    }
//    println(kotlin.name)
}



fun checkParameters(obj: MyCustomClass) {
    val dataField = MyCustomClass::class.java.getDeclaredField("data")
    val hasDataAnnotation = dataField.getAnnotation(Loggable::class.java) != null
    // Similar check for other potential annotated parameters

    if (hasDataAnnotation) {
        // Do something when data parameter is present
    } else {
        // Do something when data parameter is missing
    }
}

class MathematicalCalculation {
    fun matrixCalculator() {
        loop@ for (element in 0..3) {
            for (subElement in 0..3) {
                if (subElement > element) break@loop
            }
        }
    }
}



//<string name="monyo_receipt_item_name">Adı</string>
//<string name="monyo_receipt_item_amount">Miqdar</string>
//<string name="monyo_receipt_item_price">Qiymət</string>
//<string name="monyo_receipt_total_sum">Ümumi cəmi</string>
//<string name="monyo_receipt_service_fee">Xidmət haqqı (8%)</string>
//<string name="monyo_receipt_total_price">Yekun məbləğ</string>
//<string name="monyo_receipt_share">Qəbzi paylaş</string>
