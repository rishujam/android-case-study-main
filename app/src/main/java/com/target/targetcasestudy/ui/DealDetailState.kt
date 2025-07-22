package com.target.targetcasestudy.ui

import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.DealDetail

data class DealDetailState(
    val id: String,
    val detail: Result<DealDetail>
)
