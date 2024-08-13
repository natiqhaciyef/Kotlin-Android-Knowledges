package com.natiqhaciyef.custom_annotations.ksp

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class Listed(val paramName: String)
