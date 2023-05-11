package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/


@Composable
fun RatingArea(rating: Double, reviewCount: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.star_512),
            contentDescription = "Rating Star",
            modifier = Modifier.size(20.dp, 20.dp)
        )
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 4.dp),
            text = rating.toString(),
            style = MaterialTheme.typography.h5,
            fontSize = 18.sp,
            color = colorResource(id = R.color.s_black)
        )
        Text(
            text = "($reviewCount)",
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            color = colorResource(id = R.color.s_secondary_text)
        )
    }
}