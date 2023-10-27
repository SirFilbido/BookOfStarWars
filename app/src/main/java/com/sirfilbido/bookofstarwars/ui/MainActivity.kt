package com.sirfilbido.bookofstarwars.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.sirfilbido.bookofstarwars.ui.navigation.Navigation
import com.sirfilbido.bookofstarwars.ui.theme.BookOfStarWarsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookOfStarWarsTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation()
                }
            }
        }
    }
}
