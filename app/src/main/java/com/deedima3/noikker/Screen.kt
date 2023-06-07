package com.deedima3.noikker

sealed class Screen(val route: String) {
    object Library : Screen("explore")
    object NovelSummary : Screen("novel_summary")
    object NovelView : Screen("novel_view")
    object Sources : Screen("source")
    object Option : Screen("option")
}
