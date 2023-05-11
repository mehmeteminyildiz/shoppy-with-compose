package com.mhmtyldz.shoppy.shoppy.ui.screens.cart

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.cart.Products

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun CartListView(
    products: ArrayList<Products>, navController: NavController
) {
    Column {
        val myProducts = remember { mutableStateListOf<Products>() }

        products.forEach {
            myProducts.add(it)
        }

        val deletedItem = remember { mutableStateListOf<Products>() }

        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(
                items = myProducts,
                itemContent = { _, item ->
                    AnimatedVisibility(
                        visible = !deletedItem.contains(item),
                        enter = expandVertically(),
                        exit = shrinkHorizontally(animationSpec = tween(durationMillis = 500)),
                    ) {
                        CartItem(
                            product = item, navController = navController
                        ) { isDelete, product ->
                            deletedItem.add(item)
                        }
                    }
                }
            )
        }
    }

}




