package com.example.sakeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Rankings(
    val copyright: String,
    val yearMonth: String,
    val overall: List<RankingItem>,
    val areas: List<AreaRanking>
)

@Serializable
data class RankingItem(val rank: Int, val score: Float, val brandId: Int)

@Serializable
data class AreaRanking(val areaId: Int, val ranking: List<RankingItem>)
