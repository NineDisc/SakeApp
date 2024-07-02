package com.example.sakeapp.ui.feature.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Rankings
import com.example.sakeapp.model.SakeRanking
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SearchViewModel : ViewModel() {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
    private val apiBaseUrl = "https://muro.sakenowa.com/sakenowa-data/api/"
    val searchResult = mutableStateOf<String?>(null)

    fun fetchSearch(result: String) {
        viewModelScope.launch {
            try {
                val response = client.get(apiBaseUrl) {
                    header("Accept", "application/json")
                    parameter("result", result)
                }
                val responseBody = response.bodyAsText()
                val rankingResponse = Json.decodeFromString<SakeRanking>(responseBody)

                // FIXME 検索結果を何にするか
                searchResult.value = rankingResponse.name
            } catch (e: Exception) {
                Log.e("SearchViewModel", "Error fetching search result", e)
            }
        }
    }
}