package com.sirfilbido.bookofstarwars.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sirfilbido.bookofstarwars.ui.theme.DroidYellow
import com.sirfilbido.bookofstarwars.ui.theme.GalaxyBlack
import com.sirfilbido.bookofstarwars.ui.theme.UnityWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarBoSW(
    navController: NavController,
    title: String,
    isBackStack: Boolean = true
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GalaxyBlack,
            titleContentColor = DroidYellow
        ),
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            if (isBackStack) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = UnityWhite,
                        contentDescription = null
                    )
                }
            }
        },
    )
}