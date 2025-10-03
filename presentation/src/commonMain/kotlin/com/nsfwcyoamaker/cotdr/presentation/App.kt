package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import churchofthedivinerodcyoa.presentation.generated.resources.Res
import churchofthedivinerodcyoa.presentation.generated.resources.intro
import churchofthedivinerodcyoa.presentation.generated.resources.intro_highlighted_part
import churchofthedivinerodcyoa.presentation.generated.resources.intro_priestess
import churchofthedivinerodcyoa.presentation.generated.resources.title
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun App() {
    MaterialTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                item {
                    Text(
                        text = stringResource(Res.string.title),
                        style = TextStyle(
                            fontSize = 58.sp,
                        )
                    )
                }

                item {
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp),
                    ) {
                        val intro = stringResource(Res.string.intro)
                        val introHighlightedPart = stringResource(Res.string.intro_highlighted_part)

                        val text = remember(intro, introHighlightedPart) {
                            buildAnnotatedString {
                                append(intro)

                                val startIndex = intro.indexOf(introHighlightedPart, ignoreCase = true)
                                if (startIndex != -1) {
                                    val endIndex = startIndex + introHighlightedPart.length
                                    addStyle(
                                        style = SpanStyle(
                                            fontSize = (1.3).em,
                                        ),
                                        start = startIndex,
                                        end = endIndex
                                    )
                                }
                            }
                        }

                        Text(
                            text = text,
                            fontSize = 28.sp,
                            lineHeight = 28.sp,
                            modifier = Modifier.weight(1f),
                        )

                        Image(
                            painter = painterResource(Res.drawable.intro_priestess),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(400.dp)
                                .wrapContentHeight()
                                .shadowBorder(),
                        )
                    }
                }
            }
        }
    }
}