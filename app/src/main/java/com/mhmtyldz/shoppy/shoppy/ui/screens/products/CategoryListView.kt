package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun CategoryListView(categoryList: ArrayList<String>, navController: NavController) {
    val selectedPosition = remember { mutableStateOf(-1) }
    var itemList = remember { mutableStateListOf<String>() }

    for (i in categoryList)
        itemList.add(i)



    LazyRow(
        contentPadding = PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        items(itemList) { item ->
            val position = itemList.indexOf(item)
            val bg =
                if (position == selectedPosition.value) colorResource(id = R.color.s_black) else colorResource(
                    id = R.color.white
                )



            CategoryItem(
                category = item,
                navController = navController,
                background = bg,
                selectedPosition = selectedPosition,
                itemPosition = position
            )
        }
    }
}