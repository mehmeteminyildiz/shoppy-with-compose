package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.products.Product
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun ProductItem(product: Product, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 4.dp,
                end = 4.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .clickable {
                Timber.e("ürün detaya git, id : ${product.id!!}")
                gotoProductDetail(
                    navController, product
                )

            },
        shape = RoundedCornerShape(5.dp),
        elevation = 2.dp,
        backgroundColor = colorResource(id = R.color.white)
    ) {

        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                backgroundColor = colorResource(id = R.color.white),
                elevation = 0.dp
            ) {
                AsyncImage(
                    model = product.thumbnail,
                    contentDescription = "Translated description of what the image contains",
                )
            }

            Text(
                text = product.title ?: "no name",
                modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = colorResource(id = R.color.s_black),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "$${product.price}",
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.s_black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}