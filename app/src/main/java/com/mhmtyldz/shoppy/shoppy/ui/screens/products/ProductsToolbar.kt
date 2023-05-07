package com.mhmtyldz.shoppy.shoppy.ui.screens.products

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import timber.log.Timber

/**
created by Mehmet E. Yıldız
 **/

@Composable
fun ProductsToolbar(navController: NavController) {
    val searchState = remember { mutableStateOf("") }
    val isSearching = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {

        BackButton(navController = navController)
        SearchCard(searchState.value) { newValue ->
            searchState.value = newValue
            Timber.e("newValue : $newValue")
//            startDelayedJob(newValue, isSearching)
        }

    }
}

fun startDelayedJob(newValue: String, isSearching: MutableState<Boolean>) {
//    GlobalScope.launch {
//        if (isSearching.value) {
//            Timber.e("aaa zaten arama yapılıyor bir şey yapma")
//            // zaten arama yapılıyor bir şey yapma
//        } else {
//            delay(1000)
//            Timber.e("aaa girilen veri : $newValue")
//            isSearching.value = true
//            getProducts(isSearching)
//        }
//    }
}


@Composable
fun SearchCard(searchState: String, function: (String) -> Unit) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = colorResource(id = R.color.white),
        modifier = Modifier.padding(
            top = 8.dp, bottom = 8.dp, end = 24.dp
        )
    ) {
        val brush = remember {
            Brush.linearGradient(
                colors = listOf(Color.Yellow, Color.Black)
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(0.dp, Color.Transparent), RoundedCornerShape(0.dp)
                ),
            value = searchState,
            shape = RoundedCornerShape(0.dp),
            onValueChange = { newText ->
                function(newText.trim())
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "Search product",
                    colorFilter = ColorFilter.tint(
                        colorResource(id = R.color.s_hint)
                    )
                )
            },
            trailingIcon = {
                IconButton(onClick = { Timber.e("open mic") }) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_mic_24),
                        contentDescription = "microphone",
                        colorFilter = ColorFilter.tint(
                            colorResource(id = R.color.s_hint)
                        )
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Search...", color = colorResource(id = R.color.s_hint)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = colorResource(id = R.color.white),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                textColor = colorResource(id = R.color.s_black)
            ),
            textStyle = MaterialTheme.typography.body1
        )
    }
}


