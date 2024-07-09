package com.natiqhaciyef.custom_annotations

import com.squareup.kotlinpoet.FileSpec
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8) // 1
class CustomAnnotationProcessor : AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(AdapterModel::class.java.canonicalName!!)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val kaptKotlinGeneratedDir =
            processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
                ?: return false

        val elements = roundEnv.getElementsAnnotatedWith(AdapterModel::class.java)
            .forEach { element ->
                val modelData = getModelData(element)
                val fileName = "${modelData.modelName}Adapter" // 1
                FileSpec.builder(modelData.packageName, fileName) // 2
                    .addType(AdapterCodeBuilder(fileName, modelData).build()) // 3
                    .build()
                    .writeTo(File(kaptKotlinGeneratedDir)) // 4
            }


        return true
    }

    private fun getModelData(elem: Element): ModelData {
        val packageName = processingEnv.elementUtils.getPackageOf(elem).toString()
        val modelName = elem.simpleName.toString()
        val annotation = elem.getAnnotation(AdapterModel::class.java)
        val layoutId = annotation.layoutId

        val viewHolderBindingData = elem.enclosedElements.mapNotNull {
            val viewHolderBinding = it.getAnnotation(ViewHolderBinding::class.java)
            if (viewHolderBinding == null) {
                null // 7
            } else {
                val elementName = it.simpleName.toString()
                val fieldName = elementName.substring(0, elementName.indexOf('$'))
                ViewHolderBindingData(fieldName, viewHolderBinding.viewId)
            }
        }
        return ModelData(packageName, modelName, layoutId, viewHolderBindingData)
    }


    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}
