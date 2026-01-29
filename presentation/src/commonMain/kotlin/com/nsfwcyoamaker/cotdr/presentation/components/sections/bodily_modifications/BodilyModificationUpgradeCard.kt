package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.presentation.theme.headerTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.default_upgrade_text
import com.nsfwcyoamaker.cotdr.resources.mod_upgrade_fervor_descr
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BodilyModificationUpgradeCard(
    state: UiControlState.Upgrade,
    onUpgrade: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = state.isSelected,
        isClickable = state.isEnabled,
        onSelected = onUpgrade,
        cornerBracketsVisible = false,
        modifier = modifier
            .alpha(if (state.isEnabled) 1f else 0.3f),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = rememberRichTextResource(state.text),
                style = headerTextStyle,
                textAlign = TextAlign.Center,
            )

            Text(
                text = rememberRichTextResource(Res.string.mod_upgrade_fervor_descr, "%s", state.fervor.let { (if(it > 0) "+" else "") + it.toString() }),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
private fun BodilyModificationCardPreview() {
    AppScope {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            BodilyModificationUpgradeCard(
                state = UiControlState.Upgrade(
                    text = Res.string.default_upgrade_text,
                    isEnabled = true,
                    isSelected = false,
                    fervor = 0,
                ),
                onUpgrade = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}