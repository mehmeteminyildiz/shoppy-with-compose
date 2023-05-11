package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun DiscountCard(discountPercentage: Double) {
    Card(
        modifier = Modifier.padding(start = 24.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp,
        backgroundColor = colorResource(id = R.color.s_red)
    ) {
        Text(
            text = "Save $discountPercentage%",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = colorResource(id = R.color.white),
            fontSize = 16.sp,
        )
    }
}