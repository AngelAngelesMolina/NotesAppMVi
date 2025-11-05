package com.jaamcoding.notesapptesting.core.data.remote.api

import com.jaamcoding.notesapptesting.core.data.remote.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("/api/")
    suspend fun searchImages(
        @Query("q") query: String,
        @Query("key") apiKey: String = API_KEY,
    ): ImageListDto?

    companion object {
        const val BASE_URL = "https://pixabay.com"
        const val API_KEY = "53100909-d3ab67556c2127285d97c34d1"
    }

}