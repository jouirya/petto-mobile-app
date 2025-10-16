package com.example.petto.data.viewModel

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

object BookmarkManager {
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    private val bookmarks = mutableSetOf<String>()

    fun isBookmarked(serviceId: String): Boolean {
        return bookmarks.contains(serviceId)
    }

    fun toggleBookmark(serviceId: String): Boolean {
        val userId = auth.currentUser?.uid
        if (userId == null) {
            Log.w("BookmarkManager", "User not logged in.")
            return false
        }

        val isNowBookmarked: Boolean

        if (bookmarks.contains(serviceId)) {
            bookmarks.remove(serviceId)
            firestore.collection("Users").document(userId)
                .collection("bookmarkedServices").document(serviceId)
                .delete()
                .addOnSuccessListener {
                    Log.d("BookmarkManager", "Bookmark removed for $serviceId")
                }
                .addOnFailureListener {
                    Log.e("BookmarkManager", "Failed to remove bookmark: ${it.message}")
                }
            isNowBookmarked = false
        } else {
            bookmarks.add(serviceId)
            firestore.collection("Users").document(userId)
                .collection("bookmarkedServices").document(serviceId)
                .set(mapOf("serviceId" to serviceId))
                .addOnSuccessListener {
                    Log.d("BookmarkManager", "Bookmark added for $serviceId")
                }
                .addOnFailureListener {
                    Log.e("BookmarkManager", "Failed to add bookmark: ${it.message}")
                }
            isNowBookmarked = true
        }

        return isNowBookmarked
    }

    fun loadBookmarks(onComplete: () -> Unit = {}) {
        val userId = auth.currentUser?.uid
        if (userId == null) {
            Log.w("BookmarkManager", "User not logged in.")
            onComplete()
            return
        }

        firestore.collection("Users").document(userId)
            .collection("bookmarkedServices")
            .get()
            .addOnSuccessListener { snapshot ->
                bookmarks.clear()
                for (doc in snapshot.documents) {
                    doc.getString("serviceId")?.let { bookmarks.add(it) }
                }
                Log.d("BookmarkManager", "Loaded ${bookmarks.size} bookmarks")
                onComplete()
            }
            .addOnFailureListener {
                Log.e("BookmarkManager", "Failed to load bookmarks: ${it.message}")
                onComplete()
            }
    }
}
