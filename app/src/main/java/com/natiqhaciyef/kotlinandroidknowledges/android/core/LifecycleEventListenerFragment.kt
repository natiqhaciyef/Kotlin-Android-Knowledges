package com.natiqhaciyef.kotlinandroidknowledges.android.core

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleEventListenerFragment : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                Log.e(TAG, "On start")
            }

            Lifecycle.Event.ON_RESUME -> {
                Log.e(TAG, "On resume")
            }

            Lifecycle.Event.ON_PAUSE -> {
                Log.e(TAG, "On pause")
           }

            Lifecycle.Event.ON_STOP -> {
                Log.e(TAG, "On stop")
            }

            Lifecycle.Event.ON_DESTROY -> {
                Log.e(TAG, "On destroy")
            }

            else -> {}
        }
    }

    companion object{
        private const val TAG = "TAG 1"
    }
}