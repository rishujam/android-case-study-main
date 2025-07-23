package com.target.targetcasestudy.ui.dealdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.target.targetcasestudy.domain.DealsRepository
import com.target.targetcasestudy.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealDetailViewModel @Inject constructor(
    private val repository: DealsRepository
) : ViewModel() {

    var state by mutableStateOf(DealDetailState(detail = Result.Loading()))

    fun init(id: String?) {
        state = state.copy(id = id)
        getDealDetail()
    }

    private fun getDealDetail() = viewModelScope.launch {
        state.id?.let {
            val detailData = repository.getDeal(it)
            state = state.copy(
                detail = detailData
            )
        } ?: run {
            state = state.copy(
                detail = Result.Error("Invalid Detail Id")
            )
        }
    }

}