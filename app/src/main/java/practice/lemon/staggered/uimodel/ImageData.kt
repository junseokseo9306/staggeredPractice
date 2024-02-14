package practice.lemon.staggered.uimodel

import java.util.UUID

data class ImageData(
    val image: String,
    val id: String = UUID.randomUUID().toString()
)