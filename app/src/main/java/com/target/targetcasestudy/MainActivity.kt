package com.target.targetcasestudy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.target.targetcasestudy.ui.navigation.NavigationStack
import com.target.targetcasestudy.ui.navigation.Screen
import com.target.targetcasestudy.ui.theme.ColorPrimary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(modifier = Modifier
                  .fillMaxSize()
                  .padding(innerPadding)) {
                    NavigationStack(Screen.DealList)
                }
            }
        }
    }
}
