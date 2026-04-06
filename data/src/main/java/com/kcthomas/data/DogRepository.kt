package com.kcthomas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    // Inject into constructor via Hilt in PROD
    private val remoteSource = RemoteDogSource()

    suspend fun getDogs() = withContext(Dispatchers.IO) {
        try {
            remoteSource.getDogs()
        } catch (_: Exception) {
            null
        }
    }
}