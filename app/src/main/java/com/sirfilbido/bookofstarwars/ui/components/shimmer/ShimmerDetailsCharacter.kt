package com.sirfilbido.bookofstarwars.ui.components.shimmer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.ui.components.card.BoSWElevatedCard
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite
import com.sirfilbido.bookofstarwars.utils.extensions.shimmerEffect

@Preview
@Composable
fun ShimmerDetailsCharacter() {
    BoSWElevatedCard {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .shimmerEffect()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                for (i in 1..3) {
                    BoxHorizontal(0.6f)
                    BoxHorizontal(0.3f)
                    BoxHorizontal(0.5f)
                }
            }
        }
    }
}
