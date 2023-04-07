package com.twish.vaxify.app.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/vaccines")
    suspend fun getAllVaccines(): VaccinesResponseDto

    // use POST to push data
    @POST("/api/child")
    fun postRequestModel(@Body childModel: ChildModel): Call<ChildModel>
}
