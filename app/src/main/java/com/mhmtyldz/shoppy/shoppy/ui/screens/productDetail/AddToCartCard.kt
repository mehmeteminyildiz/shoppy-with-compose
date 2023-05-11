package com.mhmtyldz.shoppy.shoppy.ui.screens.productDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun AddToCartCard(modifier: Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = colorResource(id = R.color.white),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 24.dp)) {
                Text(
                    text = "$243.00",
                    modifier = Modifier.padding(vertical = 2.dp),
                    color = colorResource(id = R.color.s_black),
                    style = MaterialTheme.typography.h5,
                    fontSize = 22.sp
                )
                Text(
                    text = "last 8 products",
                    modifier = Modifier.padding(vertical = 2.dp),
                    color = colorResource(id = R.color.s_red2),
                    style = MaterialTheme.typography.body1,
                    fontSize = 16.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    backgroundColor = colorResource(id = R.color.s_black),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(top = 24.dp, bottom = 24.dp, end = 24.dp),
                    elevation = 4.dp
                ) {
                    Text(
                        text = "Add to Cart",
                        color = colorResource(id = R.color.white),
                        style = MaterialTheme.typography.h5,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 32.dp)
                    )
                }
            }

        }
    }
}