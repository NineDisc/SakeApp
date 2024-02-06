package com.example.sakeapp.ui.feature.ranking

import androidx.compose.runtime.mutableStateListOf
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


    //JSONをMapに格納して、ランキングの値から全て情報取り出したい。
    private var rankingsApiResult: Rankings? = null
    private var brandsApiResult: Brands? = null
    private var breweriesApiResult: Breweries? = null
    private var areasApiResult: Areas? = null
    val rankingList = mutableStateListOf<SakeRanking>()
    fun fetch() {
        viewModelScope.launch {
            try {
                val rankingsResponse = client.get("${apiBaseUrl}rankings")
                val brandsResponse = client.get("${apiBaseUrl}brands")
                val breweriesResponse = client.get("${apiBaseUrl}breweries")
                val areasResponse = client.get("${apiBaseUrl}areas")
                rankingsApiResult = rankingsResponse.body()
                brandsApiResult = brandsResponse.body()
                breweriesApiResult = breweriesResponse.body()
                areasApiResult = areasResponse.body()
                for (index in 0..10) {
                    val rankingItem = rankingsApiResult?.overall?.get(index)
                    val brand =
                        brandsApiResult?.brands!!.last { brands -> rankingItem?.brandId == brands.id }
                    val brewery =
                        breweriesApiResult?.breweries!!.last { brewery -> brewery.id == brand.id }
                    val area = areasApiResult?.areas!!.last { area -> area.id == brewery.areaId }
                    val brandName = brand.name
                    val breweryName = brewery.name
                    val areaName = area.name
                    if (rankingItem != null) {
                        rankingList.add(
                            SakeRanking(
                                rank = rankingItem.rank,
                                name = brandName,
                                breweries = breweryName,
                                area = areaName
                            )
                        )
                    }
                }
            } catch (_: Exception) {

            }
        }
    }
}