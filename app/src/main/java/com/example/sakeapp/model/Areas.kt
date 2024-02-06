package com.example.sakeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Areas(val copyright: String, val areas: List<Area>)

@Serializable
data class Area(val id: Int, val name: String)