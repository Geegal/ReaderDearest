package com.example.firebasestorage.navigation

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.ui.theme.screens.books.AddProductsScreen
import com.example.firebasestorage.ui.theme.screens.home.HomeScreen2
import com.example.firebasestorage.ui.theme.screens.login.LoginScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            LoginScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen2(navController = navController)
        }
        composable(ADD_BOOKS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_BOOKS_URL){

        }

    }
}