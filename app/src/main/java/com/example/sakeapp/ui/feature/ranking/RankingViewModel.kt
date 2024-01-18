package com.example.sakeapp.ui.feature.ranking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Rankings
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class RankingViewModel : ViewModel() {
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    private val apiUrl = "https://muro.sakenowa.com/sakenowa-data/api/rankings"

    private var sakeNames: Rankings? = null
    fun fetch() {
        viewModelScope.launch {
            try {
                val response = client.get(apiUrl)
                sakeNames = response.body()
            } catch (e: Exception) {
                Log.e("ERROR_API", "fetch_error")
            }

            Log.d("SAKE_API", "FINALLY:\n${sakeNames}")
        }
    }
}