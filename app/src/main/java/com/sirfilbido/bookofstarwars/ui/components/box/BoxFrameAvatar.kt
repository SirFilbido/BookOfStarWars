package com.sirfilbido.bookofstarwars.ui.components.box

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sirfilbido.bookofstarwars.R
import com.sirfilbido.bookofstarwars.ui.theme.DroidSilver
import com.sirfilbido.bookofstarwars.ui.theme.GalaxyBlack

private val shape = RoundedCornerShape(12.dp)

@Composable
fun BoSWBoxFrameAvatar(content: @Composable () -> Unit = {}) {
    Box(Modifier.clip(shape)) {
        BoxFrame(GalaxyBlack, 1.dp) {
            BoxFrame(DroidSilver, 1.5.dp) {
                BoxFrame(GalaxyBlack, 1.dp) {
                    BoxFrame(DroidSilver, 1.5.dp) {
                        BoxFrame(GalaxyBlack, 1.5.dp) {
                            content()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BoxFrame(
    color: Color,
    padding: Dp,
    content: @Composable () -> Unit = {}
) {
    Box(
        Modifier
            .background(color)
            .padding(padding)
            .clip(shape)
    ) { content() }
}

@Preview
@Composable
fun BoSWBoxFrameAvatarPreview() {
    BoSWBoxFrameAvatar(
        content = {
            Image(
                painter = painterResource(id = R.drawable.character_1),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier.height(150.dp)
            )
        }
    )
}
