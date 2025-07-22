package com.target.targetcasestudy.domain.model

data class Deal(
    val id: String,
    val title: String,
    val aisle: String,
    val description: String,
    val regularPrice: Price,
    val salePrice: Price?,
    val imageUrl: String,
    val availability: String,
    val fulfillment: String,
)