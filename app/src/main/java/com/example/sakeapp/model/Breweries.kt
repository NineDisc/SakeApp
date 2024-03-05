package com.example.sakeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Breweries(val copyright: String, val breweries: List<Brewery>)

@Serializable
data class Brewery(val id: Int, val name: String, val areaId: Int)