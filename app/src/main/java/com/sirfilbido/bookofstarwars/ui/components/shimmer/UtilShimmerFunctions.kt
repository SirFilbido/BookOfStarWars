package com.sirfilbido.bookofstarwars.ui.components.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.utils.extensions.shimmerEffect

@Composable
fun BoxHorizontal(fraction: Float = 1f) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .height(14.dp)
            .shimmerEffect()
    )
}
