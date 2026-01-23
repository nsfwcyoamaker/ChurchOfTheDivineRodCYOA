package com.nsfwcyoamaker.cotdr.presentation.components.sections.bodily_modifications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.model.UiControlState
import com.nsfwcyoamaker.cotdr.presentation.theme.headerTextStyle
import compose.icons.FeatherIcons
import compose.icons.feathericons.Minus
import compose.icons.feathericons.Plus
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BodilyModificationMultiBuyCard(
    state: UiControlState.MultiBuy,
    onBuyMore: () -> Unit,
    onBuyLess: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = true,
        isClickable = false,
        onSelected = {},
        cornerBracketsVisible = false,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.Center)
        ) {
            val iconSize = 32.dp
            Icon(
                imageVector = FeatherIcons.Minus,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .requiredSize(iconSize)
                    .clip(CircleShape)
                    .clickable(onClick = onBuyLess)
            )
            Text(
                text = state.count.toString() + if(state.max != null) "/" + state.max.toString() else "",
                style = headerTextStyle.copy(
                    fontWeight = FontWeight.Bold,
                ),
                textAlign = TextAlign.Center,
            )
            Icon(
                imageVector = FeatherIcons.Plus,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .requiredSize(iconSize)
                    .clip(CircleShape)
                    .alpha(if(state.canBuyMore) 1f else 0.3f)
                    .clickable(enabled = state.canBuyMore, onClick = onBuyMore)
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
            BodilyModificationMultiBuyCard(
                state = UiControlState.MultiBuy(
                    count = 1,
                    max = 4,
                    canBuyMore = true,
                ),
                onBuyMore = {},
                onBuyLess = {},
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .wrapContentHeight(),
            )
        }
    }
}