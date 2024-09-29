package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.module

import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.Owner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class OwnerModule(
//    val name: String   // it works only with dagger 2
) {

    @Provides
    fun providesOwner(): Owner {
        return Owner("Natiq Haciyev")
    }
}