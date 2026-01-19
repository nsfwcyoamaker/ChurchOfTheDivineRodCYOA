package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.theme.ChoiceBackgroundColor

@Composable
fun Modifier.choiceContour() = this
    .cornerBracketBorder()
    .padding(12.dp)
    .background(ChoiceBackgroundColor)
    .padding(horizontal = 10.dp, vertical = 4.dp)