package com.jaamcoding.notesapptesting.core.domain.repository

import com.jaamcoding.notesapptesting.core.domain.model.Images

interface ImagesRepository {
    suspend fun searchImages(query:String) : Images?
}