package com.target.targetcasestudy.data.model

import com.squareup.moshi.Json

data class DealResponse(
    val aisle: String,
    val availability: String,
    val description: String,
    val fulfillment: String,
    val id: Int,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "regular_price")
    val regularPrice: PriceDto,
    @Json(name = "sale_price")
    val salePrice: PriceDto,
    val title: String
)