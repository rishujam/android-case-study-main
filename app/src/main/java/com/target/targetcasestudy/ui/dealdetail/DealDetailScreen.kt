package com.target.targetcasestudy.ui.dealdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.Result
import com.target.targetcasestudy.domain.model.DealDetail
import com.target.targetcasestudy.ui.deals.ErrorState
import com.target.targetcasestudy.ui.theme.ColorPrimary
import com.target.targetcasestudy.ui.theme.ColorPrimaryDark
import com.target.targetcasestudy.ui.theme.GrayColor
import com.target.targetcasestudy.ui.theme.GrayDarkColor
import com.target.targetcasestudy.ui.theme.GrayMediumColor
import com.target.targetcasestudy.ui.theme.RobotoFontFamily

@Composable
fun DealDetailScreen(state: DealDetailState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(32.dp),
                painter = painterResource(R.drawable.btn_back),
                contentDescription = "back_btn"
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = "Details",
                color = GrayDarkColor,
                fontSize = 18.sp,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(700)
            )
        }
        Divider()
        when(state.detail) {
            is Result.Error -> {
                ErrorState(state.detail.message.toString())
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
            is Result.Success -> {
                state.detail.data?.let {
                    DetailSuccessState(it)
                } ?: run {
                    ErrorState("No Data")
                }
            }
        }

    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailSuccessState(detail: DealDetail) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            GlideImage(
                contentScale = ContentScale.Crop,
                contentDescription = "product_image",
                model = detail.imageUrl,
                modifier = Modifier.size(328.dp).clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = detail.title,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(400),
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = detail.salePrice?.displayString ?: detail.regularPrice.displayString,
                    color = ColorPrimaryDark,
                    fontSize = 20.sp,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(700)
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
                    text = "reg. ${detail.regularPrice.displayString}",
                    color = GrayDarkColor,
                    fontSize = 12.sp,
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight(400)
                )
            }
            Text(
                text = detail.fulfillment,
                color = GrayColor,
                fontSize = 12.sp,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(400)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Product Details",
                color = GrayDarkColor,
                fontSize = 18.sp,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(700)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = detail.description,
                color = GrayMediumColor,
                fontSize = 16.sp,
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight(400)
            )
        }
        Divider()
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Add to cart",
                modifier = Modifier.clickable {

                }.background(ColorPrimary).padding(vertical = 10.dp),
                fontFamily = RobotoFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            )
        }
    }

}
