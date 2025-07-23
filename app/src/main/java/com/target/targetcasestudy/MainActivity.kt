package com.target.targetcasestudy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.target.targetcasestudy.ui.navigation.NavigationStack
import com.target.targetcasestudy.ui.navigation.Screen
import com.target.targetcasestudy.ui.theme.ColorPrimary
import com.target.targetcasestudy.ui.theme.ColorPrimaryDark
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemUiController = rememberSystemUiController()
            val statusBarColor = ColorPrimaryDark
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = statusBarColor,
                    darkIcons = true
                )
            }
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavigationStack(Screen.DealList)
                }
            }
        }
    }
}
