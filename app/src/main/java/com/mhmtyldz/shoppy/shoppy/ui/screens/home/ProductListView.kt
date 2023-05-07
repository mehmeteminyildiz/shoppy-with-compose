package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.products.Product

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun ProductListView(title: String, productList: ArrayList<Product>, navController: NavController) {
    Column(
        modifier = Modifier.padding(top = 16.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                title,
                modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                style = MaterialTheme.typography.h5,
                fontSize = 18.sp
            )
            Text(
                "View All",
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .clickable {
                        gotoProducts(navController = navController, category = title)
                    },
                style = MaterialTheme.typography.body1,
                color = colorResource(id = R.color.s_border),
                fontSize = 16.sp
            )

        }

        LazyRow(
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
        ) {
            items(productList.size) { index ->
                ProductItem(product = productList[index], navController = navController)
            }
        }
    }

}
