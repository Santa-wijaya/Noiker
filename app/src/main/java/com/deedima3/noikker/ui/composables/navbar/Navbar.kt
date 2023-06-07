package com.deedima3.noikker.ui.composables.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.deedima3.noikker.ui.theme.*

@Composable
fun Navbar(navController: NavController) {
    val navItems = listOf(
        BottomNavItem.Sources,
        BottomNavItem.Library,
        BottomNavItem.Option
    )

    val bottomNavModifier = Modifier
        .shadow(5.dp)
        .height(80.dp)
        .background(BottomDrawerColor)
        .fillMaxWidth()
        .padding(
            start = 2.dp,
            top = 5.dp,
            end = 2.dp,
            bottom = 5.dp
        )


    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination
    
    Row(modifier = bottomNavModifier, horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
        navItems.forEach() {
                item -> NavigationItemCard(
            route = item.route, icon = item.icon,
            currentDestination = currentDestination,
            navController = navController,
            title = item.title)
        }
    }
    
}

@Composable
fun NavigationItemCard(
    route : String,
    icon : Int,
    currentDestination : NavDestination?,
    navController: NavController,
    title : String) {

    val selected = currentDestination?.hierarchy?.any { it.route == route } == true

    val contentColor =
        if (selected) SelectedNavItemColor
        else BottomDrawerColor

    val contentWeight =
        if (selected) FontWeight.Medium
        else FontWeight.Bold

    fun onItemClick(route : String) {
        navController.navigate(route) {
            navController.graph.startDestinationRoute?.let { screen_route ->
                popUpTo(screen_route) {
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val boxModifier = Modifier
        .clickable {
            onItemClick(route)
        }
        .width(70.dp)
        .height(70.dp)
        .padding(
            3.dp
        )
        .clip(RoundedCornerShape(8.dp))
        .background(contentColor)
        .border(
            1.dp,
            BottomDrawerColor,
            shape = RoundedCornerShape(8.dp),
        )


    val iconModifier = Modifier
        .height(30.dp)
        .width(30.dp)


    Column(modifier = boxModifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Icon(painter = painterResource(id = icon), contentDescription = title, tint = IconColor, modifier = iconModifier)
        Text(text = title, fontFamily = Poppins, fontWeight = contentWeight)
    }
}