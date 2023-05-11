package com.mhmtyldz.shoppy.shoppy.ui.screens.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.cart.Products

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun CartList(products: ArrayList<Products>, navController: NavController) {
    CartListView(
        products = products,
        navController = navController
    )

}