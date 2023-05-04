package com.mhmtyldz.shoppy.shoppy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhmtyldz.shoppy.shoppy.ui.screens.forgot_password.ForgotPasswordScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.home.HomeScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.initial.InitialScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.login.LoginScreen
import com.mhmtyldz.shoppy.shoppy.ui.screens.register.RegisterScreen
import com.mhmtyldz.shoppy.shoppy.ui.theme.ShoppyTheme
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.FORGOT_PASSWORD_SCREEN
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.HOME_SCREEN
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.INITIAL_SCREEN
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.LOGIN_SCREEN
import com.mhmtyldz.shoppy.shoppy.ui.utils.ScreenNameConstants.REGISTER_SCREEN

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppyTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = HOME_SCREEN) {

                    composable(INITIAL_SCREEN) {
                        InitialScreen(navController = navController)
                    }
                    composable(LOGIN_SCREEN) {
                        LoginScreen(navController = navController)
                    }
                    composable(HOME_SCREEN) {
                        HomeScreen(navController = navController)
                    }
                    composable(REGISTER_SCREEN) {
                        RegisterScreen(navController = navController)
                    }
                    composable(FORGOT_PASSWORD_SCREEN) {
                        ForgotPasswordScreen(navController = navController)
                    }
                }

            }
        }

    }
}

