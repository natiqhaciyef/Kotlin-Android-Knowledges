package com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.natiqhaciyef.kotlinandroidknowledges.R
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.PixelPhone
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.clazz.SmartPhone
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.component.DaggerPhoneComponent
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.component.DaggerSmartPhoneComponent
import com.natiqhaciyef.kotlinandroidknowledges.android.dependency_inject.di.module.OwnerModule
import com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room.AppDatabase
import com.natiqhaciyef.kotlinandroidknowledges.android.local_db.room.CustomField
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

class TestingDaggerActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var phone: PixelPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_dagger)

        // Dagger 2 - way 1 (with @Inject constructors for every single class)
//        DaggerSmartPhoneComponent
//            .create()
//            .getSmartPhone()

        // Dagger 2 (@InstallIn side is only hilt) - way2 (with module)
//        DaggerPhoneComponent
//            .create()
//            .getPhoneComponent()

        // Dagger 2 - way 3 (with field injection)
//        DaggerSmartPhoneComponent.create().inject(this)

        // Dagger 2 - way 4 (with constructor parameter or other name is state of module)
//        DaggerPhoneComponent.builder().ownerModule(OwnerModule()).build()
//            .inject(this)

        // Dagger 2 - way 5 (using all component or manual injections in application class onCreate() method)
        // in this method rotation of screen would create new instance of application class. That's why use
        // @Singleton annotation for all provided classes (such as SmartPhone or Phone)

    }
}


