package com.kcthomas.data

import retrofit2.http.GET

private const val MAX_IMAGES = 50

interface DogApi {
    @GET("api/breeds/image/random")
    suspend fun getDog(): Dog?

    @GET("api/breeds/image/random/$MAX_IMAGES")
    suspend fun getDogs(): Dog?
}