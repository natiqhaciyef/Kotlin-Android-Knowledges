package com.natiqhaciyef.kotlinandroidknowledges.android.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MoshiService {
    //    natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json?token=GHSAT0AAAAAACBSOQ665GEVVUPUTJR4SPCSZCSAX3A
    private const val BASE_URL = "https://raw.githubusercontent.com/"

    private val moshiBuilder = Moshi.Builder()
        .add(KotlinJsonAdapterFactory::class.java)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
            .build()
    }

}