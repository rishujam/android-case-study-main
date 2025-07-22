package com.target.targetcasestudy.domain.model

data class Deal(
    val id: String,
    val title: String,
    val aisle: String,
    val description: String,
    val regularPrice: Price
)