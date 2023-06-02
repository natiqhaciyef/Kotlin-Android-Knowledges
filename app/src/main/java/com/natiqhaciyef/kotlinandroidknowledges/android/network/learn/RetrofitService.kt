package com.natiqhaciyef.kotlinandroidknowledges.android.network.learn

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    // GET, POST, DELETE, UPDATE
//    natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json?token=GHSAT0AAAAAACBSOQ665GEVVUPUTJR4SPCSZCSAX3A


    @GET("natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json?token=GHSAT0AAAAAACBSOQ665GEVVUPUTJR4SPCSZCSAX3A")
    fun getAllCountriesCall(): Call<List<CountryDataClass>>     // Call with Retrofit

    @GET("natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json?token=GHSAT0AAAAAACBSOQ67ZBHEAIYGM7SLROUAZCSIYVQ")
    fun getAllCountriesRxJava(): Observable<List<CountryDataClass>>     // Observable with Retrofit

    @GET("natiqhaciyef/Country-JSON/main/Country%20API%20kit/Country%20API.json?token=GHSAT0AAAAAACBSOQ67ZBHEAIYGM7SLROUAZCSIYVQ")
    suspend fun getAllCountriesCoroutine(): List<CountryDataClass>
}