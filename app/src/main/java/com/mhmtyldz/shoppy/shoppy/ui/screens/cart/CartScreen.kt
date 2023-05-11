package com.mhmtyldz.shoppy.shoppy.ui.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.cart.CartResponse
import com.mhmtyldz.shoppy.shoppy.data.cart.Products

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun CartScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController = navController)
                Text(
                    text = "Cart",
                    style = MaterialTheme.typography.body1,
                    fontSize = 28.sp,
                    color = colorResource(id = R.color.s_black)
                )
            }
            val productList = ArrayList<Products>()
            productList.add(
                Products(
                    id = 1,
                    title = "Product 1",
                    price = (100..20000).random(),
                    quantity = (1..5).random(),
                    total = (100..20000).random(),
                    discountPercentage = (1..50).random().toDouble(),
                    discountedPrice = (1..50).random(),
                )
            )
            productList.add(
                Products(
                    id = 2,
                    title = "Product 2",
                    price = (100..20000).random(),
                    quantity = (1..5).random(),
                    total = (100..20000).random(),
                    discountPercentage = (1..50).random().toDouble(),
                    discountedPrice = (1..50).random(),
                )
            )
            productList.add(
                Products(
                    id = 3,
                    title = "Product 3",
                    price = (100..20000).random(),
                    quantity = (1..5).random(),
                    total = (100..20000).random(),
                    discountPercentage = (1..50).random().toDouble(),
                    discountedPrice = (1..50).random(),
                )
            )
            CartList(
                products = productList, navController = navController
            )
            MyDivider()
            Summary(CartResponse(2131, productList, 5203, 4800, 1231, 8, 14))
        }
    }
}

@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .fillMaxWidth()
            .height(1.dp),
        color = colorResource(id = R.color.s_border) // Renk kaynağınızı buraya ekleyin
    )
}

@Composable
fun Summary(cartResponse: CartResponse) {
    Column(
        modifier = Modifier.padding(bottom = 128.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp, start = 24.dp, end = 24.dp),
            text = "Summary",
            style = MaterialTheme.typography.body1,
            fontSize = 22.sp,
            color = colorResource(id = R.color.s_black)
        )
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Total Products",
                modifier = Modifier.weight(1.5f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black)

            )
            Text(
                text = "${cartResponse.totalProducts} products",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black),
            )
        }
        MyDivider()
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Total Quantity",
                modifier = Modifier.weight(1.5f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black)

            )
            Text(
                text = "${cartResponse.totalQuantity} items",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black),
            )
        }
        MyDivider()
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Total Price",
                modifier = Modifier.weight(1.5f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black)
            )
            Text(
                text = "$${cartResponse.total}",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black),
            )
        }

        MyDivider()
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Total Discount",
                modifier = Modifier.weight(1.5f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black)

            )
            Text(
                text = "$${cartResponse.discountedTotal}",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_green),
            )
        }
        MyDivider()
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Text(
                "Discounted Price",
                modifier = Modifier.weight(1.5f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black)

            )
            Text(
                text = "$${cartResponse.discountedTotal}",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.body1,
                fontSize = 14.sp,
                color = colorResource(id = R.color.s_black),
            )
        }
        MyDivider()
    }
}


private fun getProducts(): ArrayList<Products> {
    val productList = ArrayList<Products>()
    for (i in 1..5) {
        val product = Products(
            id = i,
            title = "Product $i",
            price = (100..20000).random(),
            quantity = (1..5).random(),
            total = (100..20000).random(),
            discountPercentage = (1..50).random().toDouble(),
            discountedPrice = (1..50).random(),
        )
        productList.add(product)
    }
    return productList
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


@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}