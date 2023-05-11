package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.products.Product
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants

/**
created by Mehmet E. Yıldız
 **/


fun gotoProductDetail(navController: NavController, product: Product) {
    navController.navigate(ScreenNameConstants.PRODUCT_DETAIL_SCREEN)
}