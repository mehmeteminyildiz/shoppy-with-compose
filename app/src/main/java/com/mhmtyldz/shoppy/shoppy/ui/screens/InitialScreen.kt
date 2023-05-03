package com.mhmtyldz.shoppy.shoppy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R
import kotlinx.coroutines.delay

/**
created by Mehmet E. Yıldız
 **/
@Composable
fun InitialScreen(
    navController: NavController,

    ) {
    SplashScreen()
    LaunchedEffect(key1 = null) {
        delay(1000)
        gotoLogin(navController = navController)
    }


}

private fun gotoLogin(navController: NavController) {
    navController.navigate("login_screen") {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}


@Composable
private fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = getBg()
                )
            ),
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Shoppy Logo",
            modifier = Modifier
                .size(100.dp, 100.dp)
                .align(Alignment.Center)
        )

        Text(
            text = stringResource(R.string.shoppy),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            color = colorResource(id = R.color.white),
            style = MaterialTheme.typography.h5
        )
    }

}

@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.s_black), colorResource(id = R.color.s_gradient_1)
    )
}
