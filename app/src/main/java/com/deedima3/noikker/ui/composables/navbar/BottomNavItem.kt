package com.deedima3.noikker.ui.composables.navbar

import com.deedima3.noikker.R
import com.deedima3.noikker.Screen

sealed class BottomNavItem(var title: String, var icon:Int, var route:String){
    object Library : BottomNavItem("Library", R.drawable.ic_bookmark_solid, Screen.Library.route)
    object Sources : BottomNavItem("Sources", R.drawable.ic_location_crossharis_solid, Screen.Sources.route)
    object Option : BottomNavItem("Option", R.drawable.ic_user_gear_solid, Screen.Option.route)
}
