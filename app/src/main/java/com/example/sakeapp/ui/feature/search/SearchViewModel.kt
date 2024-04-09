package com.example.sakeapp.ui.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Areas
import com.example.sakeapp.model.Brands
import com.example.sakeapp.model.Breweries
import com.example.sakeapp.model.Rankings
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SearchViewModel: ViewModel(){
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(
                Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    private val apiBaseUrl = "https://muro.sakenowa.com/sakenowa-data/api/"

    private var year = ""
    private var month = ""
    fun fetch() {
        viewModelScope.launch {
            try {
                val rankingsApiResult: Rankings = client.get("${apiBaseUrl}rankings").body()
                val brandsApiResult = client.get("${apiBaseUrl}brands").body<Brands>()
                val breweriesApiResult = client.get("${apiBaseUrl}breweries").body<Breweries>()
                val areasApiResult = client.get("${apiBaseUrl}areas").body<Areas>()
                year = rankingsApiResult.yearMonth.substring(0, 4)
                month = rankingsApiResult.yearMonth.substring(4, 6)

            } catch (e: Exception) {
                // TODO エラー処理の実装
            }
        }
    }

}