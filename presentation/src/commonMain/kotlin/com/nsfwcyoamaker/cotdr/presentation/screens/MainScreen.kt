package com.nsfwcyoamaker.cotdr.presentation.screens

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
import com.nsfwcyoamaker.cotdr.presentation.components.CustomWordSpacingText
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.presentation.theme.mainTitleTextStyle
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
fun MainScreen() {
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
                CustomWordSpacingText(
                    text = stringResource(Res.string.title),
                    wordSpacingFactor = 0.35f,
                    style = mainTitleTextStyle,
                )
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(horizontal = 80.dp),
                ) {
                    val introHighlightedPart = stringResource(Res.string.intro_highlighted_part)
                    val introNormal = stringResource(Res.string.intro_normal)

                    val text = remember(introNormal, introHighlightedPart) {
                        buildAnnotatedString {
                            withStyle(SpanStyle(fontSize = (1.4).em)) {
                                append(introHighlightedPart)
                            }
                            append(introNormal)
                        }
                    }

                    Text(
                        text = text,
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = Color.White,
                        ),
                        modifier = Modifier.weight(1f),
                    )

                    Image(
                        painter = painterResource(Res.drawable.intro_priestess),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(360.dp)
                            .wrapContentHeight()
                            .shadowBorder(),
                    )
                }
            }

            item {
                Text(
                    text = stringResource(Res.string.intro_priestess_part_1),
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        color = Color.Yellow,
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(36.dp)) }

            item {
                SectionTitle(
                    title = stringResource(Res.string.section_title_priestesses),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(horizontal = 80.dp),
                )
            }
        }
    }
}