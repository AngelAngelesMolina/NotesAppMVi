package com.jaamcoding.notesapptesting.core.data.mapper

import com.jaamcoding.notesapptesting.core.data.remote.dto.ImageListDto
import com.jaamcoding.notesapptesting.core.domain.model.Images

fun ImageListDto.toImages(): Images {
    return Images(
        images = hits?.map { imageDto ->
            imageDto.previewURL ?: ""
        } ?: emptyList()
    )
}