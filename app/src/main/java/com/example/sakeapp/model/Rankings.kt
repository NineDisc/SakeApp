package com.example.sakeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Rankings(val copyright: String, val yearMonth: String, val overall: List<RankingsInfo>)

@Serializable
data class RankingsInfo(val rank: Int, val score: Float, val brandId: Int)
