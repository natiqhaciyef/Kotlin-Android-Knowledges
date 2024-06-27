package com.natiqhaciyef.kotlinandroidknowledges.kotlin.advanced.annotations

import android.R
import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.security.AccessController.getContext


class Seasons(
    val name: String,
)

fun main() {
    val runtimeKClass = Seasons::class
    val runtimeClassJava = runtimeKClass.constructors
    val runtimeClassKotlin = runtimeKClass.annotations

    println(runtimeClassJava)
    println(runtimeClassKotlin)
}