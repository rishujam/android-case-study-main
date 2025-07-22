package com.target.targetcasestudy.data.model

import com.squareup.moshi.Json

data class DealDto(
    val id: String,
    val title: String,
    val aisle: String,
    val description: String,
    @Json(name = "image_url")
    val imageUrl: String,
    val fulfillment: String,
    val availability: String,
    @Json(name = "regular_price")
    val regularPrice: PriceDto
)