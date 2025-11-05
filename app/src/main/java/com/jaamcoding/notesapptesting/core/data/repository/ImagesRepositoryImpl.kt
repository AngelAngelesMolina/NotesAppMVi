package com.jaamcoding.notesapptesting.core.data.repository

import com.jaamcoding.notesapptesting.core.data.mapper.toImages
import com.jaamcoding.notesapptesting.core.data.remote.api.ImagesApi
import com.jaamcoding.notesapptesting.core.domain.model.Images
import com.jaamcoding.notesapptesting.core.domain.repository.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesRepository {
    override suspend fun searchImages(query: String): Images? {
        return imagesApi.searchImages(query)?.toImages()
    }
}