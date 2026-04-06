package com.kcthomas.data

import retrofit2.http.GET

private const val MAX_IMAGES = 6

interface DogApi {
    @GET("api/breeds/image/random")
    suspend fun getDog(): Dog?

    @GET("api/breeds/image/random/6")
    suspend fun getDogs(): Array<Dog>
}