package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.products.Product

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun ProductList(productList: ArrayList<Product>, navController: NavController) {
    ProductListView(
        productList = productList,
        navController = navController
    )

}