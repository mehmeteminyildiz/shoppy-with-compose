package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun BackButton(navController: NavController) {
    Image(
        painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
        contentDescription = "Search product",
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                goBack(navController = navController)
            },
        colorFilter = ColorFilter.tint(
            colorResource(id = R.color.s_black)
        )
    )
}

fun goBack(navController: NavController) {
    navController.popBackStack()
}