package com.example.sakeapp.ui.feature.ranking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Rankings
import com.example.sakeapp.model.RankingsInfo
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

    //    var sakeNames = mutableStateOf<List<String>>(emptyList())
    var sakeNames: Rankings = Rankings("aaa", "aaaaaa", listOf(RankingsInfo(1, 1.0f, 1)))

    init {
        viewModelScope.launch {
//            try {
            val response = client.get("https://muro.sakenowa.com/sakenowa-data/api/rankings")
//            sakeNames.value = response.bodyAsText()
            sakeNames = response.body()
            Log.d("SAKE_API", "API called")
//            } catch (e: Exception) {
            Log.e("ERROR_API", "aaaaa")
//            }

            Log.d("SAKE_API", sakeNames.toString())
        }

    }
}