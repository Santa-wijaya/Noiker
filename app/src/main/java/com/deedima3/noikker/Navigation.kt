package com.deedima3.noikker

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deedima3.noikker.ui.composables.navbar.Navbar
import com.deedima3.noikker.ui.screen.LibraryScreen
import com.deedima3.noikker.ui.screen.OptionScreen
import com.deedima3.noikker.ui.screen.SourceScreen
import com.deedima3.noikker.ui.theme.BlackBackgroundColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation(){
    val navController = rememberNavController()
    val scaffoldModifier = Modifier.background(BlackBackgroundColor)
    Scaffold(
        bottomBar = { Navbar(navController = navController) },
        modifier = scaffoldModifier
    ) {
        NavHost(navController = navController, startDestination = Screen.Library.route) {
            composable(Screen.Library.route) {
                LibraryScreen(navController = navController)
            }
            composable(Screen.Option.route) {
                OptionScreen(navController = navController)
            }
            composable(Screen.Sources.route) {
                SourceScreen(navController = navController)
            }
        }
    }
}