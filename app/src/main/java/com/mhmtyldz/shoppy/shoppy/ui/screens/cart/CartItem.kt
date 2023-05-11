package com.mhmtyldz.shoppy.shoppy.ui.screens.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.mhmtyldz.shoppy.shoppy.R
import com.mhmtyldz.shoppy.shoppy.data.cart.Products
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun CartItem(
    product: Products,
    navController: NavController,
    function: (isDelete: Boolean, product: Products) -> Unit
) {
    val quantityState = remember { mutableStateOf(value = product.quantity ?: 0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 4.dp, end = 4.dp, top = 8.dp, bottom = 8.dp
            ),
        shape = RoundedCornerShape(5.dp),
        elevation = 0.dp,
        backgroundColor = colorResource(id = R.color.white)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Birinci elemanı oluştur
            Box(
                modifier = Modifier
                    .weight(0.1f)
                    .background(colorResource(id = R.color.white))
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    elevation = 0.dp,
                    backgroundColor = Color.Transparent,
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Column {
                        AsyncImage(
                            model = getImageByIndex(product.id!!),
                            contentDescription = "Translated description of what the image contains",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                        )

                    }
                }
            }

            // İkinci elemanı oluştur
            Box(
                modifier = Modifier
                    .weight(0.2f)
                    .background(colorResource(id = R.color.white))
                    .padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
                // İçerik buraya gelecek
                Column {
                    Text(
                        text = product.title ?: "no name",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h5,
                        color = colorResource(id = R.color.s_black),
                        fontSize = 16.sp,
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$${product.price}",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body1,
                            textDecoration = TextDecoration.LineThrough,
                            color = colorResource(id = R.color.s_secondary_text),
                            fontSize = 16.sp,
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "$${product.discountedPrice}",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h5,
                            color = colorResource(id = R.color.s_black),
                            fontSize = 18.sp,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(backgroundColor = colorResource(id = R.color.s_grey_light),
                            elevation = 0.dp,
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier.clickable {
                                val newQuantity = quantityState.value - 1
                                if (newQuantity <= 0) {
                                    Timber.e("girdi 1")
                                    function(true, product)
                                } else {
                                    quantityState.value = quantityState.value - 1
                                }

                            }) {
                            Image(
                                painter = painterResource(id = R.drawable.minus_128),
                                contentDescription = "Minus",
                                modifier = Modifier
                                    .padding(4.dp)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }

                        Card(
                            backgroundColor = Color.Transparent,
                            modifier = Modifier.padding(horizontal = 16.dp),
                            elevation = 0.dp,
                        ) {
                            Text(text = quantityState.value.toString())
                        }

                        Card(backgroundColor = colorResource(id = R.color.s_grey_light),
                            elevation = 0.dp,
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier.clickable {
                                quantityState.value = quantityState.value + 1

                            }) {
                            Image(
                                painter = painterResource(id = R.drawable.plus_128_3),
                                contentDescription = "Plus",
                                modifier = Modifier
                                    .padding(4.dp)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }

                    }


                }

            }


        }
    }
}

private fun getImageByIndex(index: Int): String {
    val urlList = arrayListOf(
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://fns.modanisa.com/r/pro2/2022/06/16/z-spor-ayakkabi--siyah--ayakkabi-havuzu-8499218-11.jpg",
        "https://www.tofisa.com/22037-beyaz-spor-ayakkabi-spor-ayakkabi-tofisa-tesettur-giyim-264634-47-B.jpg",
        "https://aydinli-polo.b-cdn.net/products/2022/11/21/634606/1360eb72-0ce6-49a5-8de7-540884c81068_size2800x2800_quality100.jpg",
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://m.media-amazon.com/images/I/71TawoxTk6L._UY500_.jpg",
        "https://fns.modanisa.com/r/pro2/2022/06/16/z-spor-ayakkabi--siyah--ayakkabi-havuzu-8499218-11.jpg",
        "https://www.tofisa.com/22037-beyaz-spor-ayakkabi-spor-ayakkabi-tofisa-tesettur-giyim-264634-47-B.jpg",
        "https://aydinli-polo.b-cdn.net/products/2022/11/21/634606/1360eb72-0ce6-49a5-8de7-540884c81068_size2800x2800_quality100.jpg"
    )

    return urlList[index]
}