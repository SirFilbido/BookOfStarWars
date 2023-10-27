package com.sirfilbido.bookofstarwars.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite

@Composable
fun ElevatedCardBoSW(
    clickable: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), colors = CardDefaults.cardColors(
            containerColor = UnityWhite,
        ), modifier = Modifier
            .padding(10.dp)
            .clickable {
                clickable()
            }
    ) {
        content()
    }
}