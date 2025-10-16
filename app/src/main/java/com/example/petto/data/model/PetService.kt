package com.example.petto.data.model

data class PetService(
    var service_id: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val service_type: String = "",
    val social_media: String? = null,
    val service: List<String> = listOf(),
    val contact_info: String = "",
    val location: String = "",
    val documentId: String = "" ,
    val average_rating: Double = 0.0,
    var isBookmarked: Boolean = false
)



