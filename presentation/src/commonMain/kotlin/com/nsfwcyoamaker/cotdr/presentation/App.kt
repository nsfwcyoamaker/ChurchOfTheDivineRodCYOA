package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.runtime.Composable
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun App() {
    AppScope {
        MainScreen()
    }
}