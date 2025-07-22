package com.target.targetcasestudy.domain.dtoMapper

import com.target.targetcasestudy.data.model.DealResponse
import com.target.targetcasestudy.data.model.DealsResponse
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.DealDetail
import com.target.targetcasestudy.domain.model.Price

fun DealsResponse.toDeals(): List<Deal> {
    return this.deals.map {
        val salePrice = it.salePrice?.let { salePrice ->
            Price(displayString = salePrice.displayString)
        }
        Deal(
            id = it.id,
            title = it.title,
            aisle = it.aisle,
            description = it.description,
            regularPrice = Price(displayString = it.regularPrice.displayString),
            salePrice = salePrice,
            imageUrl = it.imageUrl,
            availability = it.availability,
            fulfillment = it.fulfillment
        )
    }
}

fun DealResponse.toDealDetail(): DealDetail {
    return DealDetail(
        aisle = this.aisle,
        availability = this.availability,
        description = this.description,
        fulfillment = this.fulfillment,
        id = this.id,
        imageUrl = this.imageUrl,
        regularPrice = Price(displayString = this.regularPrice.displayString),
        salePrice = Price(displayString = this.salePrice.displayString),
        title = this.title
    )
}