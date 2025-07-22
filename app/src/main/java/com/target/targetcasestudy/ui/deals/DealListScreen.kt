package com.target.targetcasestudy.ui.deals

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.ui.theme.ColorAccent
import com.target.targetcasestudy.ui.theme.ColorPrimary
import com.target.targetcasestudy.ui.theme.ColorPrimaryDark
import com.target.targetcasestudy.ui.theme.GrayColor
import com.target.targetcasestudy.ui.theme.GrayDarkColor
import com.target.targetcasestudy.ui.theme.RobotoFontFamily

@Composable
fun DealListScreen(
    modifier: Modifier = Modifier,
    state: DealListState,
    navController: NavController
) {
    Column (modifier = modifier) {
        Text(
            modifier = Modifier.padding(top = 12.dp, start = 8.dp),
            text = "List",
            fontSize = 18.sp,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight(700),
            color = GrayDarkColor
        )
        Spacer(modifier.height(20.dp))
        Divider()
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Deal(dealItem: Deal) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            model = dealItem.imageUrl,
            contentDescription = "",
            modifier = Modifier.size(140.dp).clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(16.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = spacedBy(4.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = dealItem.salePrice?.displayString ?: dealItem.regularPrice.displayString,
                    color = ColorPrimaryDark,
                    fontSize = 20.sp,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(700)
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                    text = "reg. ${dealItem.regularPrice.displayString}",
                    color = GrayDarkColor,
                    fontSize = 12.sp,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(400)
                )
            }
            Text(
                text = dealItem.fulfillment,
                color = GrayColor,
                fontSize = 12.sp,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(400)
            )
            Text(
                text = dealItem.title,
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(400),
                color = Color.Black,
                maxLines = 2
            )
            Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                Text(
                    text = dealItem.availability,
                    color = ColorAccent,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "in aisle ${dealItem.aisle.toUpperCase(Locale.current)}",
                    color = Color.Gray,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp
                )
            }

        }
    }
    Divider()
}
