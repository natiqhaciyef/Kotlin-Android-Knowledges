package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.component

import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.TestingDaggerActivity
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.Phone
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.module.BrandModule
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.module.OwnerModule
import dagger.Component

@Component(modules = [OwnerModule::class, BrandModule::class])
interface PhoneComponent {
//    fun getPhoneComponent(): Phone

    fun inject(testingDaggerActivity: TestingDaggerActivity)
}
