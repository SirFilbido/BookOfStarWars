package com.sirfilbido.bookofstarwars.ui.feature.character.listCharacter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite
import com.sirfilbido.bookofstarwars.utils.extensions.shimmerEffect

@Composable
fun ShimmerListCharacter() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), colors = CardDefaults.cardColors(
            containerColor = UnityWhite,
        ),
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .shimmerEffect()
            )

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                BoxHorizontal()
                BoxHorizontal(0.7f)
                BoxHorizontal(0.9f)
            }
        }
    }
}

@Composable
private fun BoxHorizontal(fraction: Float =1f) {
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .height(16.dp)
            .shimmerEffect()
    )
}
