package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.products.Product

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun ProductList(title: String,productList: ArrayList<Product>, navController: NavController) {
    ProductListView(title = title, productList = productList, navController = navController)
}