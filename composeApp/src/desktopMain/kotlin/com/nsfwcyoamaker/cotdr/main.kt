package com.nsfwcyoamaker.cotdr

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.nsfwcyoamaker.cotdr.presentation.App

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(placement = WindowPlacement.Maximized),
            title = "Church of the Divine Rod",
        ) {
            App()
        }
    }
}