package com.natiqhaciyef.kotlinandroidknowledges.android.network.learn

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    // GET, POST, DELETE, UPDATE

    @GET("")
    fun getAllCountriesCall(): Call<List<CountryDataClass>>     // Call with Retrofit

    @GET("")
    fun getAllCountriesRxJava(): Observable<List<CountryDataClass>>     // Observable with Retrofit

    @GET("")
    suspend fun getAllCountriesCoroutine(): List<CountryDataClass>
}