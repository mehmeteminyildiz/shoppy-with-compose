package com.mhmtyldz.shoppy.shoppy.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun BackButton(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .zIndex(1f)
            .clickable {
                navController.popBackStack()
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(100),
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription = "Search product",
            modifier = Modifier.padding(8.dp),
            colorFilter = ColorFilter.tint(
                colorResource(id = R.color.s_black)
            )
        )
    }
}