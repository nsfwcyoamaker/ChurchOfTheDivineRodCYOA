package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsfwcyoamaker.cotdr.presentation.components.main.CathedralBackground

@Composable
fun PreviewScope(
    content: @Composable () -> Unit,
) {
    AppScope {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            CathedralBackground(
                Modifier.fillMaxSize(),
            )

            content()
        }
    }
}