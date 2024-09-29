package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.component

import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.TestingDaggerActivity
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.SmartPhone
import dagger.Component

@Component
interface SmartPhoneComponent {

    // constructor injection
//    fun getSmartPhone(): SmartPhone

    // field injection
    fun inject(testingDaggerActivity: TestingDaggerActivity)
}