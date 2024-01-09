package com.sirfilbido.bookofstarwars.ui.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite

@Composable
fun BoSWElevatedCard(
    clickable: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = UnityWhite),
        modifier = Modifier
            .padding(10.dp)
            .clickable { clickable?.let { it() } }
    ) {
        content()
    }
}

@Preview
@Composable
fun BoSWElevatedCardPreview() {
    BoSWElevatedCard(
        clickable = {},
        content = { Box(Modifier.size(100.dp, 80.dp)) }
    )
}
