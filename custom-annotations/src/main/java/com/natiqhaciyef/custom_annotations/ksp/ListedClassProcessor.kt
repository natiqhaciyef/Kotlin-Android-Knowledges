package com.natiqhaciyef.custom_annotations.ksp

import com.google.devtools.ksp.getConstructors
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.validate
import kotlin.reflect.KClass

class ListedClassProcessor(val environment: SymbolProcessorEnvironment) : SymbolProcessor {
    private fun Resolver.findAnnotatedClasses(kClass: KClass<*>) =
        getSymbolsWithAnnotation(kClass.qualifiedName.toString())
            .filterIsInstance<KSClassDeclaration>()
            .filter {
                it.getConstructors().all { constructor -> constructor.parameters.isEmpty() }
            }

    override fun process(resolver: Resolver): List<KSAnnotated> {
        val listedClasses: Sequence<KSClassDeclaration> =
            resolver.findAnnotatedClasses(Listed::class)

        if (!listedClasses.iterator().hasNext()) return emptyList()

        val imports = listedClasses.mapNotNull { it.qualifiedName?.asString() }.toSet()
        val lists = listedClasses.groupBy {
            it.annotations
                .first { it.shortName.asString() == "Listed" }.arguments
                .first().value.toString()
        }

        val sourceFiles = listedClasses.mapNotNull { it.containingFile }

        val fileText = buildString {
            append("package com.natiqhaciyef.kotlinandroidknowledges")

            newLine()
            newLine()

            imports.forEach {
                append("import $it")
                newLine()
            }

            newLine()

            lists.forEach { (listName, functions) ->
                val classNames = functions.map { it.simpleName.asString() + "()" }.joinToString(", ")

                append("val $listName = listOf($classNames)")
                newLine()

            }

        }

        createFileWithText(sourceFiles, fileText)
        return (listedClasses).filterNot { it.validate() }.toList()
    }

    private fun createFileWithText(
        sourceFiles: Sequence<KSFile>,
        fileText: String,
    ) {
        val file = environment.codeGenerator.createNewFile(
            Dependencies(
                false,
                *sourceFiles.toList().toTypedArray(),
            ),
            "com.natiqhaciyef.kotlinandroidknowledges",
            "GeneratedLists"
        )

        file.write(fileText.toByteArray())
    }

    private fun StringBuilder.newLine(count: Int = 1) {
        repeat(count){
            append("\n")
        }
    }
}


class ListedClassProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return ListedClassProcessor(environment)
    }
}