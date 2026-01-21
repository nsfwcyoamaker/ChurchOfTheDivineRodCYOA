package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.theme.ChoiceBackgroundColor

@Composable
fun SelectableCard(
    isSelected: Boolean,
    isClickable: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
    glowColor: Color = Color(0x97FFEF64),
    content: @Composable BoxScope.() -> Unit,
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

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clickable(
                enabled = isClickable,
                interactionSource = interactionSource,
                indication = null,
            ) { onSelected() }
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
                    color = glowColor,
                    shape = RoundedCornerShape(2.dp) // Shape must be here
                )
        )

        Box(
            content = content,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    clip = false // Allow glow to bleed
                }
                .padding(contentPadding)
                .background(ChoiceBackgroundColor)
                .padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}