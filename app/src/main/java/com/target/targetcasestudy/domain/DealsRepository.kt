package com.target.targetcasestudy.domain

import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.DealDetail

interface DealsRepository {

    suspend fun getDeals(): Result<List<Deal>>

    suspend fun getDeal(id: String): Result<DealDetail>

}