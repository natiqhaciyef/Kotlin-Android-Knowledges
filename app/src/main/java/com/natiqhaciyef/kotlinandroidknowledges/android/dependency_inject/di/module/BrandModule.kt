package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.module

import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.PhoneBrand
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.PixelPhone
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BrandModule {

//    @Provides
//    fun provideBrand(phoneBrand: PixelPhone): PhoneBrand {
//        return phoneBrand
//        // because we use @Inject annotation on PixelPhone class and it will be injected
//         // for posting here
//    }


    @Binds
    abstract fun bindBrand(phoneBrand: PixelPhone): PhoneBrand
}