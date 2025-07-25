package com.target.targetcasestudy.ui.deals

import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.Deal

data class DealListState(
    val deals: Result<List<Deal>>
)
