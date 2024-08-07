package com.example.sakeapp.ui.feature.ranking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sakeapp.model.Areas
import com.example.sakeapp.model.Brands
import com.example.sakeapp.model.Breweries
import com.example.sakeapp.model.Rankings
import com.example.sakeapp.model.SakeRanking
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val rankingList = mutableListOf<SakeRanking>()
    private var year = ""
    private var month = ""

    private val _uiState = MutableStateFlow<RankingUiState>(RankingUiState.Initial)
    val uiState: StateFlow<RankingUiState> = _uiState
    fun fetch() {
        viewModelScope.launch {
            try {
                val rankingsApiResult: Rankings = client.get("${apiBaseUrl}rankings").body()
                val brandsApiResult = client.get("${apiBaseUrl}brands").body<Brands>()
                val breweriesApiResult = client.get("${apiBaseUrl}breweries").body<Breweries>()
                val areasApiResult = client.get("${apiBaseUrl}areas").body<Areas>()
                year = rankingsApiResult.yearMonth.substring(0, 4)
                month = rankingsApiResult.yearMonth.substring(4, 6)

                for (index in 0..9) {
                    val rankingItem = rankingsApiResult.overall[index]
                    val brand =
                        brandsApiResult.brands.last { brands -> rankingItem.brandId == brands.id }
                    val brewery =
                        breweriesApiResult.breweries.last { brewery -> brewery.id == brand.breweryId }
                    val area = areasApiResult.areas.last { area -> area.id == brewery.areaId }
                    val brandName = brand.name
                    val breweryName = brewery.name
                    val areaName = area.name
                    rankingList.add(
                        SakeRanking(
                            rank = rankingItem.rank,
                            name = brandName,
                            breweries = breweryName,
                            area = areaName
                        )
                    )
                }
            } catch (_: Exception) {

            }
            _uiState.value = RankingUiState.Contents(rankingList, year, month)
        }
    }
}