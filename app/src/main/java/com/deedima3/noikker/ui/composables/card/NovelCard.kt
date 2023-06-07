package com.deedima3.noikker.ui.composables.card


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.deedima3.noikker.utils.cutText

@Composable
fun NovelCard(
    imageUrl : String,
    title : String,
    imageContentDesc : String,
) {
    val cardModifier = Modifier
    val boxModifier = Modifier

    fun cutNovelCard(text : String) : String {
        return cutText(text, 35)
    }

    Card(
        modifier = cardModifier,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = boxModifier) {
            AsyncImage(
                model = imageUrl,
                contentDescription = imageContentDesc,
                modifier = Modifier.size(128.dp),
                contentScale = ContentScale.Crop)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = cutNovelCard(title), color = Color.White, fontSize = 16.sp)
            }
        }
    }
}