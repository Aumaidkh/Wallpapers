package com.hopcape.wallpapers.data.repo

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hopcape.wallpapers.domain.model.WallpaperModel
import com.hopcape.wallpapers.domain.repo.IWallpapersRepository
import kotlinx.coroutines.tasks.await

class FirebaseWallpapersRepositoryImpl: IWallpapersRepository {

    private val firestoreRef by lazy {
        Firebase.firestore
    }

    override suspend fun getWallpapers(): List<WallpaperModel>? {
        return firestoreRef
            .collection(WALLPAPERS_COLLECTION)
            .get()
            .await()
            .map {
                WallpaperModel(
                    imageUrl = it.getString("url") ?: "",
                    category = it.getString("category") ?: "",
                    name = it.getString("name") ?: ""
                )
            }
    }

    override suspend fun getWallpapersFor(category: String): List<WallpaperModel>? {
        return emptyList()
    }

    companion object {
        const val WALLPAPERS_COLLECTION = "wallpapers"
    }
}