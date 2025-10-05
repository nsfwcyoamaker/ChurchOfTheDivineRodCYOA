package com.nsfwcyoamaker.cotdr.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.presentation.components.shadowBorder
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(
    widthDp = 1920,
    heightDp = 1080,
)
@Composable
fun App() {
    MaterialTheme { //todo proper theme
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            Image(
                contentDescription = null,
                painter = painterResource(Res.drawable.cathedral_02_preprocessed),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                item { Spacer(modifier = Modifier.height(60.dp)) }

                item {
                    Text(
                        text = stringResource(Res.string.title),
                        style = TextStyle(
                            fontSize = 58.sp,
                            color = Color.White,
                        )
                    )
                }

                item { Spacer(modifier = Modifier.height(24.dp)) }

                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp),
                    ) {
                        val introHighlightedPart = stringResource(Res.string.intro_highlighted_part)
                        val introNormal = stringResource(Res.string.intro_normal)

                        val text = remember(introNormal, introHighlightedPart) {
                            buildAnnotatedString {
                                withStyle(SpanStyle(fontSize = (1.3).em)) {
                                    append(introHighlightedPart)
                                }
                                append(introNormal)
                            }
                        }

                        Text(
                            text = text,
                            style = TextStyle(
                                fontSize = 28.sp,
                                lineHeight = 28.sp,
                                color = Color.White,
                            ),
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

                item {
                    Text(
                        text = stringResource(Res.string.intro_priestess_part_1),
                        style = TextStyle(
                            fontSize = 28.sp,
                            lineHeight = 28.sp,
                            color = Color.Yellow,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp),
                    )
                }

                item { Spacer(modifier = Modifier.height(36.dp)) }

                item {
                    SectionTitle(
                        title = stringResource(Res.string.section_title_priestesses),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 80.dp),
                    )
                }
            }
        }
    }
}