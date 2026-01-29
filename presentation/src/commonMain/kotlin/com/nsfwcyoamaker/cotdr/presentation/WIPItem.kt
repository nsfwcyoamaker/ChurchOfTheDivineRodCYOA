package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FeatherIcons
import compose.icons.feathericons.AlertOctagon

@Composable
fun WIPItem(
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .background(color = Color.Black.copy(alpha = 0.66f), shape = RoundedCornerShape(22.dp))
            .padding(horizontal = 12.dp, vertical = 18.dp)
    ) {
        Icon(
            imageVector = FeatherIcons.AlertOctagon,
            contentDescription = null,
            tint = Color.Red,
        )

        Text(
            text = "Section under construction",
            color = Color.Red,
        )
    }
}