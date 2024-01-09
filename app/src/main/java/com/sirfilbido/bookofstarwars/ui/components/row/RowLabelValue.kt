package com.sirfilbido.bookofstarwars.ui.components.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.ui.theme.GalaxyBlack

@Composable
fun RowLabelValue(label: String, value: String, isShow: Boolean = true) {
    if (isShow) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = label, color = GalaxyBlack)
            Text(text = value, color = GalaxyBlack)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowLabelValuePreview() {
    RowLabelValue(
        label = "Label text",
        value = "Value text",
    )
}

@Preview(showBackground = true)
@Composable
fun RowLabelValuePreviewIsShowFalse() {
    RowLabelValue(
        label = "Label text",
        value = "Value text",
        isShow = false
    )
}
