package com.example.petto.data.viewModel

import com.example.petto.data.model.PetService

object FavoriteManager {
    private val favorites = mutableSetOf<PetService>()

    fun isFavorite(service: PetService): Boolean {
        return favorites.any { it.documentId == service.documentId }
    }

    fun toggleFavorite(service: PetService) {
        if (isFavorite(service)) {
            favorites.removeIf { it.documentId == service.documentId }
        } else {
            favorites.add(service)
        }
    }

    fun getFavorites(): List<PetService> = favorites.toList()
}
