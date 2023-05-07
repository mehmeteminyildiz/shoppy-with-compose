package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun HomeToolbar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp),
    ) {

        Text(
            text = "Shoppy", style = MaterialTheme.typography.h5, fontSize = 22.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_search_32),
                contentDescription = "Search product",
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clickable {
                        gotoProducts(navController = navController, category = "")
                    },
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Image(
                painter = painterResource(id = R.drawable.outline_shopping_cart_32),
                contentDescription = "Go to cart",
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clickable {
                        gotoCart(navController = navController)
                    },
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
        }
    }
}

