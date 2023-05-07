package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


/** Horizontal listing of categories **/
@Composable
fun CategoryListView(categoryList: ArrayList<String>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        items(categoryList.size) { index ->
            CategoryItem(category = categoryList[index], navController)
        }
    }
}