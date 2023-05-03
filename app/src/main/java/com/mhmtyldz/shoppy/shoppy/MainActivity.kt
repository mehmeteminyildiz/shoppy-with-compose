package com.mhmtyldz.shoppy.shoppy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhmtyldz.shoppy.shoppy.ui.screens.HomeScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.LoginScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.RegisterScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.InitialScreen
import com.mhmtyldz.shoppy.shoppy.ui.theme.ShoppyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppyTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "initial_screen") {
                    composable("initial_screen") {
                        InitialScreen(navController = navController)
                    }
                    composable("login_screen") {
                        LoginScreen(navController = navController)
                    }
                    composable("home_screen") {
                        HomeScreen(navController = navController)
                    }
                    composable("register_screen") {
                        RegisterScreen(navController = navController)
                    }
                }

            }
        }

    }
}

