package com.example.sakeapp.ui.feature.ranking

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Brands
import com.example.sakeapp.model.Rankings
import com.example.sakeapp.model.SakeRanking
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
    private val apiBaseUrl = "https://muro.sakenowa.com/sakenowa-data/api/"

    private var rankingsApiResult: Rankings? = null
    private var brandsApiResult: Brands? = null
    val rankingList = mutableStateListOf<SakeRanking>()
    fun fetch() {
        viewModelScope.launch {
            try {
                val rankingsResponse = client.get("${apiBaseUrl}rankings")
                val brandsResponse = client.get("${apiBaseUrl}brands")
                rankingsApiResult = rankingsResponse.body()
                brandsApiResult = brandsResponse.body()
                for (index in 0..9) {
                    val rankingItem = rankingsApiResult?.overall?.get(index)
                    for (brand in brandsApiResult?.brands!!) {
                        if (rankingItem?.brandId == brand.id) {
                            rankingList.add(SakeRanking(rankingItem.rank, brand.name))
                        }
                    }
                }
            } catch (_: Exception) {

            }
        }
    }
}