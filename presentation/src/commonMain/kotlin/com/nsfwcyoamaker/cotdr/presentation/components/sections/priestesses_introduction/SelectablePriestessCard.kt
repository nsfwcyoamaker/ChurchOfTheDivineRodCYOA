package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.components.cornerBracketBorder
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.theme.ChoiceBackgroundColor
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun SelectablePriestessCard(
    title: StringResource,
    image: DrawableResource,
    description: StringResource,
    isSelected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    // --- Animation Config ---

    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.03f else if (isHovered) 1.01f else 1f,
        label = "Scale",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessMedium,
        ),
    )

    val bracketsOffset by animateDpAsState(
        targetValue = if (isSelected) 24.dp else if (isHovered) 2.dp else 0.dp,
        label = "bracketsOffset",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessMedium,
        ),
    )

    val glowRadius by animateDpAsState(
        targetValue = if (isSelected) 8.dp else 0.dp,
        label = "GlowRadius",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessMedium,
        ),
    )

    val glowSize by animateDpAsState(
        targetValue = if (isSelected) 12.dp else 0.dp,
        label = "GlowRadius",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessMedium,
        ),
    )

    val contentPadding = 12.dp

    val glowPadding by remember {
        derivedStateOf {
            contentPadding - (glowSize / 2)
        }
    }

    val colorMatrix = remember(isSelected, isHovered) {
        if (isSelected) ColorMatrix().apply { setToSaturation(1.4f) }
        else if (isHovered) ColorMatrix().apply { setToSaturation(1.12f) }
        else ColorMatrix().apply { setToSaturation(1.0f) }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable(interactionSource = interactionSource, indication = null) { onSelected() }
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(bracketsOffset.coerceAtLeast(0.dp))
                .cornerBracketBorder()
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    scaleX = scale * 0.99f
                    scaleY = scale * 0.99f
                    clip = false // Allow glow to bleed
                }
                .padding(glowPadding)
                .blur(
                    radius = glowRadius,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded,
                )
                .border(
                    width = glowSize,
                    color = Color(0x97FFEF64),
                    shape = RoundedCornerShape(2.dp) // Shape must be here
                )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    clip = false // Allow glow to bleed
                }
                .padding(contentPadding)
                .background(ChoiceBackgroundColor)
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(
                text = rememberRichTextResource(title),
                style = smallTitleTextStyle,
            )

            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.colorMatrix(colorMatrix),
                modifier = Modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = false)
                    .padding(horizontal = 18.dp)
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .shadowBorder()
            )

            Text(
                text = rememberRichTextResource(description),
                style = smallerTextStyle,
            )
        }
    }
}