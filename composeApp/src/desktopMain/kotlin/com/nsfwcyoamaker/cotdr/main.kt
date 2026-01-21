package com.nsfwcyoamaker.cotdr

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.nsfwcyoamaker.cotdr.data.di.dataModule
import com.nsfwcyoamaker.cotdr.domain.di.domainModule
import com.nsfwcyoamaker.cotdr.presentation.App
import com.nsfwcyoamaker.cotdr.presentation.di.presentationModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(
            dataModule(),
            domainModule(),
            presentationModule(),
        )
    }

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