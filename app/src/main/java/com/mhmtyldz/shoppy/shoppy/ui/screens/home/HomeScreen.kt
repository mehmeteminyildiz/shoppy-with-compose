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
import androidx.compose.foundation.layout.Spacer
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
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.CART_SCREEN
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.PRODUCTS_SCREEN
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
            CustomToolbar(navController = navController)
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
        contentPadding = PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp)
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
fun CustomToolbar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp),
    ) {

        Text(
            text = "Shoppy", style = MaterialTheme.typography.h5, fontSize = 22.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_search_32),
                contentDescription = "Search product",
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clickable {
                        gotoProducts(navController = navController)
                    },
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Image(
                painter = painterResource(id = R.drawable.outline_shopping_cart_32),
                contentDescription = "Go to cart",
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .clickable {
                        gotoCart(navController = navController)
                    },
                colorFilter = ColorFilter.tint(
                    colorResource(id = R.color.s_black)
                )
            )
        }
    }
}

fun gotoCart(navController: NavController) {
    navController.navigate(CART_SCREEN)
}

fun gotoProducts(navController: NavController) {
    navController.navigate(PRODUCTS_SCREEN)
}

@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}

