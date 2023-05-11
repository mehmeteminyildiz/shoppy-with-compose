package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.products.Product
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun ProductsScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Column {
            ProductsToolbar(navController = navController)
            CategoryList(navController = navController)
            ProductList(
                productList = getProduct(), navController = navController
            )
        }
    }
}


fun getProduct(): ArrayList<Product> {
    Timber.e("getProduct()")
    val productList = ArrayList<Product>()
    for (i in 1..100) {
        productList.add(getRandomProduct())
    }
    return productList
}

private fun getRandomProduct(): Product {
    val product = Product(
        id = (1..100).random(),
        title = getRandomTitle(),
        price = (100..20000).random(),
        images = arrayListOf(
            "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
            "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg"
        ),
        thumbnail = getRandomImage()
    )
    return product
}

private fun getRandomTitle(): String {
    val titleList = arrayListOf(
        "ZenithTech ProX",

        "LuminaMax Ultra",
        "NovaGlow X1",
        "TitanVista Elite",
        "StellarFlex Prime",
        "ElixirPlus Vantage",
        "QuantumEdge Nexus",
        "SerenityPulse Zephyr",
        "RadiantWave Luxe",
        "OptiCore Spectrum"
    )
    return titleList[(0 until titleList.size).random()]
}

private fun getRandomImage(): String {
    val urlList = arrayListOf(
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://fns.modanisa.com/r/pro2/2022/06/16/z-spor-ayakkabi--siyah--ayakkabi-havuzu-8499218-11.jpg",
        "https://www.tofisa.com/22037-beyaz-spor-ayakkabi-spor-ayakkabi-tofisa-tesettur-giyim-264634-47-B.jpg",
        "https://aydinli-polo.b-cdn.net/products/2022/11/21/634606/1360eb72-0ce6-49a5-8de7-540884c81068_size2800x2800_quality100.jpg"
    )

    return urlList[(0 until urlList.size).random()]
}

@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}