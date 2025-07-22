package com.target.targetcasestudy.ui

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
class DealListViewModel @Inject constructor(
    private val repository: DealsRepository
) : ViewModel() {

    var state by mutableStateOf(DealListState(deals = Result.Loading()))

    init {
        getDeals()
    }

    private fun getDeals() = viewModelScope.launch {
        val deals = repository.getDeals()
        state = state.copy(
            deals = deals
        )
    }

}