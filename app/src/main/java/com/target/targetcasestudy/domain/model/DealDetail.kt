package com.target.targetcasestudy.domain.model

data class DealDetail(
    val aisle: String,
    val availability: String,
    val description: String,
    val fulfillment: String,
    val id: Int,
    val imageUrl: String,
    val regularPrice: Price,
    val salePrice: Price?,
    val title: String
)
