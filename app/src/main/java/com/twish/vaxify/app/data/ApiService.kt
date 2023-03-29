package com.twish.vaxify.app.data

import retrofit2.http.GET

interface ApiService {
    @GET("api/vaccines")
   suspend fun getAllVaccines(): VaccinesResponseDto

   // use POST to push data
}
