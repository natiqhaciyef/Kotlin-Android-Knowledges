package com.natiqhaciyef.kotlinandroidknowledges.android.network.practice

import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("recipes/random")
    suspend fun getAllRandomRecipes(
        @Query("apiKey") key: String = "ce12108d1735475b87abd305f7896803"
    ): RecipeListObject

}
