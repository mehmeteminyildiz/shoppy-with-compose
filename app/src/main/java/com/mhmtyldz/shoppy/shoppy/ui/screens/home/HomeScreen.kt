package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.products.Product

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            HomeToolbar(navController = navController)
            CategoryList(navController = navController)
            ProductList(
                title = "Smart Phones",
                productList = getSmartPhones(),
                navController = navController
            )
            ProductList(
                title = "Laptops",
                productList = getSmartPhones(),
                navController = navController
            )
            ProductList(
                title = "Skincare",
                productList = getSmartPhones(),
                navController = navController
            )
        }

    }
}

private fun getSmartPhones(): ArrayList<Product> {
    val product = Product(
        id = 1231,
        title = "Erkek ayakkabı Nikeas dasdas das dasd asd a",
        price = 844,
        images = arrayListOf(
            "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
            "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg"
        ),
        thumbnail = "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg"
    )

    return arrayListOf(product, product, product, product, product, product, product)
}


@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}

