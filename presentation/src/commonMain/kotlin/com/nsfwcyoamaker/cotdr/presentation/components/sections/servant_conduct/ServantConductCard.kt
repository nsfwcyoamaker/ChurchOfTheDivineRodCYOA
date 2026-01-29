package com.nsfwcyoamaker.cotdr.presentation.components.sections.servant_conduct

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
import com.nsfwcyoamaker.cotdr.presentation.model.ServantConductOption
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import org.jetbrains.compose.resources.painterResource

@Composable
fun ServantConductCard(
    servantConductOption: ServantConductOption,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = false,
        isClickable = false,
        onSelected = {},
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = rememberRichTextResource(servantConductOption.title),
                    style = smallTitleTextStyle,
                )

                Text(
                    text = rememberRichTextResource(servantConductOption.description),
                    style = smallerTextStyle,
                )

                Box(modifier = Modifier.weight(1f))
            }

            Image(
                painter = painterResource(servantConductOption.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .shadowBorder()
            )
        }
    }
}