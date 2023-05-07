package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants

/**
created by Mehmet E. Yıldız
 **/

fun gotoProducts(navController: NavController, category: String) {
    navController.navigate(ScreenNameConstants.PRODUCTS_SCREEN)
}

fun gotoCart(navController: NavController) {
    navController.navigate(ScreenNameConstants.CART_SCREEN)
}

