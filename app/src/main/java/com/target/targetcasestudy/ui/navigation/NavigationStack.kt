package com.target.targetcasestudy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.target.targetcasestudy.ui.dealdetail.DealDetailScreen
import com.target.targetcasestudy.ui.deals.DealListScreen
import com.target.targetcasestudy.ui.deals.DealListViewModel

@Composable
fun NavigationStack(startDestination: Screen) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination.route) {
        composable(route = Screen.DealList.route) {
            val detailListViewModel: DealListViewModel = hiltViewModel()
            DealListScreen(
                navController = navController,
                state = detailListViewModel.state
            )
        }
        composable(
            route = Screen.DealDetail.route + "?id={id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            DealDetailScreen()
        }
    }
}