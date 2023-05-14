package com.natiqhaciyef.kotlinandroidknowledges.android.network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.natiqhaciyef.kotlinandroidknowledges.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkActivity : AppCompatActivity() {
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private lateinit var list: MutableList<CountryDataClass>

    // for using api and delete caches
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        list = mutableListOf()
        compositeDisposable = CompositeDisposable()
//        loadDataWithCall()
//        loadDataWithRxJava()
//        loadDataWithCoroutines()

    }

    fun loadDataWithCall() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)
        val call = service.getAllCountriesCall()

        call.enqueue(object : Callback<List<CountryDataClass>> {
            override fun onResponse(
                call: Call<List<CountryDataClass>>,
                response: Response<List<CountryDataClass>>
            ) {
                if (response.isSuccessful) {
                    // success
                    response.body()?.let {
                        list.clear()
                        list.addAll(it.toMutableList())
                        println("In Response: $list")
                    }
                } else {
                    // fail
                }
            }

            override fun onFailure(call: Call<List<CountryDataClass>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun loadDataWithRxJava() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RetrofitService::class.java)


        compositeDisposable?.add(
            retrofit.getAllCountriesRxJava()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    this::handler,
                    this::onErrorHandler
                )
        )
    }

    fun loadDataWithCoroutines() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                val list = service.getAllCountriesCoroutine()
                println(list)
            }
        }
    }

    private fun handler(list: List<CountryDataClass>) {
        val mutableList = list.toMutableList()
        println(mutableList)
    }

    private fun onErrorHandler(t: Throwable) {
        println(t.message)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}


