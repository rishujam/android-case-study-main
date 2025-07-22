package com.target.targetcasestudy.domain.dtoMapper

import com.target.targetcasestudy.data.model.DealResponse
import com.target.targetcasestudy.data.model.DealsResponse
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.DealDetail
import com.target.targetcasestudy.domain.model.Price

fun DealsResponse.toDeals(): List<Deal> {
    return this.deals.map {
        Deal(
            id = it.id,
            title = it.title,
            aisle = it.aisle,
            description = it.description,
            regularPrice = Price(
                amountInCents = it.regularPrice.amountInCents,
                displayString = it.regularPrice.displayString
            )
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
        regularPrice = Price(
            amountInCents = this.regularPrice.amountInCents,
            displayString = this.regularPrice.displayString
        ),
        salePrice = Price(
            amountInCents = this.salePrice.amountInCents,
            displayString = this.salePrice.displayString
        ),
        title = this.title
    )
}