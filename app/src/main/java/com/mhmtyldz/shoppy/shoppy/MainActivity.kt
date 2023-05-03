package com.mhmtyldz.shoppy.shoppy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhmtyldz.shoppy.shoppy.ui.screens.LoginScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.SplashScreen
import com.mhmtyldz.shoppy.shoppy.ui.theme.ShoppyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppyTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash_screen") {
                    composable("splash_screen") {
                        SplashScreen(navController = navController)
                    }
                    composable("login_screen") {
                       LoginScreen(navController = navController)
                    }
                }

            }
        }

    }
}

