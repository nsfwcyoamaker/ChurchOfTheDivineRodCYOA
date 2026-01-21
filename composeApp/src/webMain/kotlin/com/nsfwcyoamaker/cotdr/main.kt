package com.nsfwcyoamaker.cotdr

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.nsfwcyoamaker.cotdr.data.di.dataModule
import com.nsfwcyoamaker.cotdr.domain.di.domainModule
import com.nsfwcyoamaker.cotdr.presentation.App
import com.nsfwcyoamaker.cotdr.presentation.di.presentationModule
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(
            dataModule(),
            domainModule(),
            presentationModule(),
        )
    }

    ComposeViewport {
        App()
    }
}