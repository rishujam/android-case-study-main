package com.target.targetcasestudy.ui

sealed class Screen(val route: String) {
    data object DealList: Screen("deal_list_screen")
    data object DealDetail: Screen("deal_detail_screen")
}