package com.target.targetcasestudy.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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