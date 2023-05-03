package com.mhmtyldz.shoppy.shoppy.ui.screens

import android.os.Handler
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mhmtyldz.shoppy.shoppy.R

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


        Text(
            text = "Home",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(bottom = 16.dp),
            color = colorResource(id = R.color.white),
            style = MaterialTheme.typography.body1
        )


    }

    Handler().postDelayed({
//        gotoLogin(navController)
    }, 1000)


}

@Composable
private fun getBg(): List<Color> {
    return listOf(
        colorResource(id = R.color.s_black), colorResource(id = R.color.s_gradient_1)
    )
}


private fun gotoLogin(navController: NavController) {
    navController.navigate("login_screen")
}
