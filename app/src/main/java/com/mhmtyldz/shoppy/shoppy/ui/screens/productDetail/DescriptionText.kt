package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.layout.padding
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
fun DescriptionText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        fontSize = 16.sp,
        color = colorResource(id = R.color.s_black),
        modifier = Modifier
            .padding(
                top = 16.dp,
                start = 24.dp,
                end = 24.dp,
                bottom = 128.dp
            ),
        textAlign = TextAlign.Justify,
    )
}