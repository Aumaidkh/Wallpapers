package com.hopcape.wallpapers.data.repo

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hopcape.wallpapers.domain.model.CatalogModel
import com.hopcape.wallpapers.domain.model.WallpaperModel
import com.hopcape.wallpapers.domain.repo.ICatalogRepository
import kotlinx.coroutines.tasks.await

class FirebaseCatalogsRepositoryImpl: ICatalogRepository {

    private val firestoreRef by lazy {
        Firebase.firestore
    }
    override suspend fun getCatalogs(): List<CatalogModel>? {
        val wallpapersList = firestoreRef
            .collection("wallpapers")
            .get()
            .await()
            .map {
                WallpaperModel(
                    imageUrl = it.getString("url") ?: "",
                    name = it.getString("name") ?: "",
                    category = it.getString("category") ?: ""
                )
            }

        return wallpapersList.groupBy {
            it.category
        }.map {
            CatalogModel(
                name = it.key,
                wallpapers = it.value
            )
        }
    }
}