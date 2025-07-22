package com.target.targetcasestudy.data.repo

import com.target.targetcasestudy.data.remote.DealsApi
import com.target.targetcasestudy.domain.DealsRepository
import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.dtoMapper.toDealDetail
import com.target.targetcasestudy.domain.dtoMapper.toDeals
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.DealDetail
import javax.inject.Inject

class DealsRepositoryImpl @Inject constructor(
    private val api: DealsApi
) : DealsRepository {

    override suspend fun getDeals(): Result<List<Deal>> {
        val response = api.getDeals()
        return if(response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.toDeals())
            } ?: run {
                Result.Error("Empty")
            }
        } else {
            Result.Error("Error: ${response.message()}")
        }
    }

    override suspend fun getDeal(id: String): Result<DealDetail> {
        val response = api.getDeal(id)
        return if(response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.toDealDetail())
            } ?: run {
                Result.Error("Error Empty")
            }
        } else {
            Result.Error("Error: ${response.message()}")
        }
    }
}