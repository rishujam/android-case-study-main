package com.target.targetcasestudy.data.model

import com.squareup.moshi.Json

data class PriceDto(
  @Json(name = "amount_in_cents")
  val amountInCents: Int,
  @Json(name = "currency_symbol")
  val currencySymbol: String,
  @Json(name = "display_string")
  val displayString: String
)
