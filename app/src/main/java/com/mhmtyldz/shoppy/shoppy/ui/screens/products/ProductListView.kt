package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.data.products.Product

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun ProductListView(
    productList: ArrayList<Product>, navController: NavController
) {


//    LazyColumn(
//        contentPadding = PaddingValues(16.dp)
//    ) {
//        items(productList.size) { index ->
//            ProductItem(product = productList[index], navController = navController)
//        }
//    }


    LazyVerticalGrid(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(productList.size) {
            ProductItem(product = productList[it], navController = navController)
        }
    }

//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Fixed(2),
//        modifier = Modifier.fillMaxSize(),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        verticalItemSpacing = 16.dp,
//        contentPadding = PaddingValues(8.dp),
//    ) {
//        Timber.e("LazyVerticalStaggeredGrid()")
//        items(productList) {
//            ProductItem(product = it, navController = navController)
//        }
//    }


}