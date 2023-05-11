package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
created by Mehmet E. Yıldız
 **/

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(imageList: ArrayList<String>) {
    val pageCount = imageList.size
    val pagerState = rememberPagerState()

    Box {
        HorizontalPager(
            pageCount = pageCount, state = pagerState,
            modifier = Modifier
                .height(300.dp)
                .align(Alignment.BottomCenter)
        ) { page ->
            AsyncImage(
                model = imageList[page],
                contentDescription = "Translated description of what the image contains",
                contentScale = ContentScale.Crop
            )
        }
        Row(
            modifier = Modifier
                .height(30.dp)
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                )
            }
        }
    }
}