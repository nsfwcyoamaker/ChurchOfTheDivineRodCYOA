package com.nsfwcyoamaker.cotdr.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.theme.ChoiceBackgroundColor
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun FollowerIntroduction(
    title: String,
    titleStyle: TextStyle,
    image: DrawableResource,
    description: AnnotatedString,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .cornerBracketBorder()
            .padding(12.dp)
            .background(ChoiceBackgroundColor)
            .padding(horizontal = 28.dp)
    ) {
        Text(
            text = title,
            style = titleStyle,
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = false),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .shadowBorder()
            )
        }

        Text(text = description)
    }
}