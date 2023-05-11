package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/


@Composable
fun BrandRow(brandName: String) {
    Row(
        modifier = Modifier.padding(
            top = 8.dp, start = 24.dp, end = 24.dp
        )
    ) {
        Text(
            brandName,
            style = MaterialTheme.typography.body1,
            fontSize = 16.sp,
            color = colorResource(id = R.color.s_secondary_text)
        )
    }
}