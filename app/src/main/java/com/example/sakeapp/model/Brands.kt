package com.example.sakeapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Brands(val copyright: String, val brands: List<Brand>)

@Serializable
data class Brand(val id: Int, val name: String, val breweryId: Int)