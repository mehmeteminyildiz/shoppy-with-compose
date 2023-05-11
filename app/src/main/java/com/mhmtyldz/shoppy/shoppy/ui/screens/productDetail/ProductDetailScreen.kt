package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun ProductDetailScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            Box {
                BackButton(navController = navController)
                ImageSlider(imageList = getImages())
            }

            BrandRow(brandName = "Brothers Shoes")

            ProductTitle(title = "Adidas Superstar")

            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                DiscountCard(discountPercentage = 4.09)
                RatingArea(rating = 4.5, reviewCount = 1881)
            }

            DescriptionText(
                text = stringResource(R.string.lorem1),
            )
        }
        AddToCartCard(modifier = Modifier.align(Alignment.BottomStart))



    }
}


private fun getImages(): ArrayList<String> {
    return arrayListOf(
        "https://akn-ss.b-cdn.net/products/2023/02/07/284400/d466eeeb-e384-4d14-b584-3f7b790ff7cc_size1400x1400_quality100_cropCenter.jpg",
        "https://akn-ss.b-cdn.net/products/2023/02/07/284399/04fe2406-f82e-4bf2-899d-54cca17edee7_size1400x1400_quality90_cropCenter.jpg",
        "https://akn-ss.b-cdn.net/products/2023/02/07/284399/b634181a-8f08-4905-9f0d-e08c13977b1c_size1400x1400_quality90_cropCenter.jpg",
        "https://akn-ss.b-cdn.net/products/2023/02/07/284400/8ee20acc-d96a-448c-9262-565e02810a32_size1400x1400_quality90_cropCenter.jpg",
        "https://akn-ss.b-cdn.net/products/2023/02/07/284399/a24d8e6a-1227-46f5-8101-a32830317758_size1400x1400_quality90_cropCenter.jpg"
    )
}


@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.white), colorResource(id = R.color.white)
    )
}