package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun CategoryList(navController: NavController) {
    val categoryList = arrayListOf(
        "smartphones",
        "laptops",
        "fragrances",
        "skincare",
        "groceries",
        "home-decoration",
        "furniture",
        "tops",
        "womens-dresses",
        "womens-shoes",
        "mens-shirts",
        "mens-shoes",
        "mens-watches",
        "womens-watches",
        "womens-bags",
        "womens-jewellery",
        "sunglasses",
        "automotive",
        "motorcycle",
        "lighting"
    )
    CategoryListView(
        categoryList = categoryList, navController = navController
    )
}