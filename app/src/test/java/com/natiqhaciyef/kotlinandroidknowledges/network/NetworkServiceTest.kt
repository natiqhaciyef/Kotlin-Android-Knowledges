package com.natiqhaciyef.kotlinandroidknowledges.network

import com.google.common.truth.Truth.assertThat
import com.natiqhaciyef.kotlinandroidknowledges.android.network.learn.RetrofitService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkServiceTest {

    private lateinit var server: MockWebServer
    private lateinit var service: RetrofitService

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }

    private fun enqueueMockServer(filename: String) {
        // for parse given file to string from json
        val inputStream = javaClass.classLoader!!.getResourceAsStream(filename)
        val source = inputStream.source().buffer()

        // for create mock response from string resource (input stream) of given file
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getUserInfo_responseReturns_correctResponseUri() {
        runBlocking{
            enqueueMockServer("userinfo.json")
            // https://api-m.sandbox.paypal.com
            // mock api testing
            val responseBody = service.getUserInfo(schema = "paypalv1.1").body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v1/identity/oauth2/userinfo?schema=paypalv1.1")
        }
    }

    @Test
    fun getUserInfo_responseReturns_correctContent(){
        runBlocking {
            enqueueMockServer("userinfo.json")
            val responseBody = service.getUserInfo(schema = "paypalv1.1").body()
            val userId = responseBody!!.userId
            val address = responseBody.address.streetAddress
            assertThat(userId).isEqualTo("https://www.paypal.com/webapps/auth/identity/user/Zq4Vzum-M3h_3MxHddpPWqpnXSKgmSol9crJTUx7gec")
            assertThat(address).isEqualTo("1 Main St")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}