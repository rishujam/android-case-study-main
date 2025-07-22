package com.target.targetcasestudy.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.ui.theme.ColorPrimary

@Composable
fun DealListScreen(
    modifier: Modifier = Modifier,
    state: DealListState,
    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxWidth()) {
        when(state.deals) {
            is Result.Success -> {
                state.deals.data?.let {
                    LazyColumn(
                        modifier = modifier,
                    ) {
                        itemsIndexed(state.deals.data) { index, deal ->
                            Deal(deal)
                        }
                    }
                } ?: run {
                    ErrorState(state.deals.message.toString())
                }
            }
            is Result.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = ColorPrimary
                    )
                }
            }
            is Result.Error -> {
                ErrorState(state.deals.message.toString())
            }
        }
    }
}

@Composable
fun ErrorState(message: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message)
    }
}

@Composable
fun Deal(dealItem: Deal) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            colorFilter = ColorFilter.tint(Color.Gray),
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = spacedBy(4.dp)
        )
        {
            Text(
                text = dealItem.title,
                modifier = Modifier.fillMaxWidth(),
                style = typography.h6,
                color = Color.Gray
            )
            Divider()
            Text(
                text = dealItem.regularPrice.displayString,
                modifier = Modifier.fillMaxWidth(),
                style = typography.subtitle1,
                color = Color.Gray
            )
        }
    }
}
