package com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun PriestessIntroductionCard(
    priestessUi: PriestessIntroductionOption.Ui,
    isSelected: Boolean,
    isClickable: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = isSelected,
        isClickable = isClickable,
        onSelected = onSelected,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = rememberRichTextResource(priestessUi.title),
                style = smallTitleTextStyle,
            )

            Image(
                painter = painterResource(priestessUi.image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .aspectRatio(1f, matchHeightConstraintsFirst = false)
                    .padding(horizontal = 18.dp)
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .shadowBorder()
            )

            Text(
                text = rememberRichTextResource(priestessUi.description),
                style = smallerTextStyle,
            )
        }
    }
}