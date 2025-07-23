package com.target.targetcasestudy.data.remote

import com.target.targetcasestudy.data.model.DealResponse
import com.target.targetcasestudy.data.model.DealsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DealsApi {

    @GET("deals")
    suspend fun getDeals(): Response<DealsResponse>

    @GET("deals/{dealId}")
    suspend fun getDeal(@Path("dealId") dealId: String): Response<DealResponse>

}