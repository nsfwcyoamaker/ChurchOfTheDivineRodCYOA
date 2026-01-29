package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.model.ServantConductOption
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ServantConductItemsRow(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ServantConductOption.entries.forEach { servantConduct ->
            ServantConductCard(
                servantConductOption = servantConduct,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun ServantConductGridItemPreview() {
    AppScope {
        ServantConductItemsRow()
    }
}