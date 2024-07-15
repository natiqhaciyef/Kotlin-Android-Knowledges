package com.natiqhaciyef.custom_annotations

import com.squareup.kotlinpoet.FileSpec
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

@SupportedSourceVersion(SourceVersion.RELEASE_8)
class CustomAnnotationProcessor : AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(AdapterModel::class.java.canonicalName!!)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val kaptKotlinGeneratedDir =
            processingEnv.options[KAPT_KOTLIN_GENERATED_PACKAGE_NAME]
                ?: return false

        roundEnv.getElementsAnnotatedWith(AdapterModel::class.java)
            .forEach { element ->
                val modelData = getModelData(element)
                val fileName = "${modelData.modelName}Adapter"
                FileSpec.builder(modelData.packageName, fileName)
                    .addType(AdapterCodeBuilder(fileName, modelData).build())
                    .build()
                    .writeTo(File(kaptKotlinGeneratedDir))
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
                null
            } else {
                val elementName = it.simpleName.toString()
                val fieldName = elementName.substring(0, elementName.indexOf('$'))
                ViewHolderBindingData(fieldName, viewHolderBinding.viewId)
            }
        }
        return ModelData(packageName, modelName, layoutId, viewHolderBindingData)
    }


    companion object {
        const val KAPT_KOTLIN_GENERATED_PACKAGE_NAME = "kapt.kotlin.generated"
    }
}
