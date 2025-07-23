package com.target.targetcasestudy.ui.dealdetail

import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.DealDetail

data class DealDetailState(
    val id: String? = null,
    val detail: Result<DealDetail>
)
