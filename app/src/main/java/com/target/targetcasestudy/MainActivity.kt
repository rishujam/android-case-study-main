package com.target.targetcasestudy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.ui.DealListScreen
import com.target.targetcasestudy.ui.NavigationStack
import com.target.targetcasestudy.ui.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NavigationStack(Screen.DealList)
    }
  }
}
