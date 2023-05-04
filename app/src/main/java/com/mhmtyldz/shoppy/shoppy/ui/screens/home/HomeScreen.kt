package com.mhmtyldz.shoppy.shoppy.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Column() {
            CustomToolbar()
            CategoryList(navController = navController)


        }

    }
}

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
    CategoryListView(categoryList = categoryList, navController = navController)

}


/** Horizontal listing of categories **/
@Composable
fun CategoryListView(categoryList: ArrayList<String>, navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {
        items(categoryList.size) { index ->
            CategoryItem(category = categoryList[index], navController)
        }
    }
}

@Composable
fun CategoryItem(category: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .border(
                BorderStroke(1.dp, colorResource(id = R.color.s_border)), RoundedCornerShape(5.dp)
            )
            .clickable {
                Timber.e("$category clicked. Redirect to Products page")
                // TODO: gotoProducts(category, navController)
            },
        shape = RoundedCornerShape(5.dp),
        elevation = 0.dp,
        backgroundColor = colorResource(id = R.color.white)
    ) {
        Text(
            text = category,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.s_black),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }

}


@Composable
fun CustomToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp),
    ) {
        Text(
            text = "Shoppy", style = MaterialTheme.typography.h5, fontSize = 22.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_search_32),
                contentDescription = "Shoppy Logo",
                modifier = Modifier.size(32.dp, 32.dp),
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
            Image(
                painter = painterResource(id = R.drawable.outline_shopping_cart_32),

                contentDescription = "Shoppy Logo",
                modifier = Modifier.size(32.dp, 32.dp),
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
        }
    }
}

@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}

