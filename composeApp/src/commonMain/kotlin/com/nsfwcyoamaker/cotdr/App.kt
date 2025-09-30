package com.nsfwcyoamaker.cotdr

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import churchofthedivinerodcyoa.composeapp.generated.resources.Res
import churchofthedivinerodcyoa.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun App() {
    MaterialTheme {
        Text(
            text = stringResource(Res.string.app_name),
        )
    }
}