package com.mhmtyldz.shoppy.shoppy.ui.screens

import androidx.compose.animation.Crossfade
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var currentScreen by remember { mutableStateOf(Screen.SPLASH) }

    LaunchedEffect(Unit) {
        delay(1000)
        currentScreen = Screen.LOGIN
    }

    Crossfade(targetState = currentScreen, modifier = Modifier.fillMaxSize()) { currentScreen ->
        if (currentScreen == Screen.SPLASH) {
            // show splash screen
            SplashScreen()
        } else {
            LoginScreen(navController = navController)
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
