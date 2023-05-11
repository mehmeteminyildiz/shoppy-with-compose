package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun CategoryItem(
    category: String,
    navController: NavController,
    background: Color,
    selectedPosition: MutableState<Int>,
    itemPosition: Int,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .border(
                BorderStroke(1.dp, colorResource(id = R.color.s_border)), RoundedCornerShape(5.dp)
            )
            .clickable {
                selectedPosition.value = itemPosition
                getProduct()
            }, shape = RoundedCornerShape(5.dp), elevation = 0.dp, backgroundColor = background
    ) {
        Text(
            text = category,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            textAlign = TextAlign.Center,
            color = if (selectedPosition.value == itemPosition) colorResource(id = R.color.white) else colorResource(
                id = R.color.s_black
            ),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}