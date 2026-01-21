package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreen

@Composable
fun App() {
    AppScope {
        Navigator(MainScreen)
    }
}