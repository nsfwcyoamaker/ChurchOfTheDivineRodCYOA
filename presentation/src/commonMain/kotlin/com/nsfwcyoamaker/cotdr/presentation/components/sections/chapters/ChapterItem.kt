package com.nsfwcyoamaker.cotdr.presentation.components.sections.chapters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.composableRichText.rememberRichTextResource
import com.nsfwcyoamaker.cotdr.presentation.AppScope
import com.nsfwcyoamaker.cotdr.presentation.components.SelectableCard
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.presentation.model.ChapterOption
import com.nsfwcyoamaker.cotdr.presentation.theme.small2TitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallTitleTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.smallerTextStyle
import com.nsfwcyoamaker.cotdr.presentation.theme.tinyTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.divider_vertical
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChapterItem(
    item: ChapterOption,
    modifier: Modifier = Modifier,
) {
    SelectableCard(
        isSelected = false,
        isClickable = false,
        onSelected = {},
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = rememberRichTextResource(item.title),
                    style = smallTitleTextStyle,
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = rememberRichTextResource(item.description),
                    style = smallerTextStyle,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Image(
                        painter = painterResource(item.image),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .weight(0.6f)
                            .wrapContentHeight()
                            .shadowBorder()
                    )

                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        item.doctrines.forEach { doctrine ->
                            Text(
                                rememberRichTextResource(doctrine.title),
                                style = tinyTitleTextStyle,
                            )
                            Text(
                                text = rememberRichTextResource(doctrine.description),
                                style = smallerTextStyle,
                            )
                        }
                    }
                }

                Text(
                    text = rememberRichTextResource(item.comment),
                    style = smallerTextStyle,
                )
            }

            Image(
                painter = painterResource(Res.drawable.divider_vertical),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(24.dp)
                    .wrapContentHeight()
                    .align(Alignment.CenterVertically),
            )

            item.tenets.forEach { tenet ->
                Column(
                    modifier = Modifier.weight(1f).padding(top = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(tenet.image),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .shadowBorder()
                    )

                    Text(
                        text = rememberRichTextResource(tenet.title),
                        style = small2TitleTextStyle,
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = rememberRichTextResource(tenet.description),
                        style = smallerTextStyle,
                    )
                }
            }
        }
    }
}

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun ChapterItemPreview() {
    AppScope {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .verticalScroll(rememberScrollState())
        ) {
            ChapterItem(
                item = ChapterOption.GuidingLight,
            )
        }
    }
}