package com.deedima3.noikker.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.deedima3.noikker.ui.composables.card.NovelCard

@Composable
fun SourceScreen(navController: NavController) {
   NovelCard(imageUrl = "https://pic.bstarstatic.com/ogv/5f96eb3ab0869f9cb49cc1e6c54e812a40bbee1a.jpg@600w_800h_1e_1c_1f.webp", title = "Kage No Jitsuryoukusha", imageContentDesc = "Kage No Jitsuryoukusha")
}