package com.target.targetcasestudy.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DealsResponse(
    @Json(name = "products")
    val deals: List<DealDto>
)
