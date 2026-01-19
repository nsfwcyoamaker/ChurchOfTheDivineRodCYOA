package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.components.MainIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.PriestessIntroductionDescription
import com.nsfwcyoamaker.cotdr.presentation.components.PriestessIntroductionExtra
import com.nsfwcyoamaker.cotdr.presentation.components.PriestessIntroductionExtra2
import com.nsfwcyoamaker.cotdr.presentation.components.PriestessIntroductionInterlude
import com.nsfwcyoamaker.cotdr.presentation.components.PriestessesIntroductionGrid
import com.nsfwcyoamaker.cotdr.presentation.components.SectionTitle
import com.nsfwcyoamaker.cotdr.presentation.theme.mainTitleTextStyle
import com.nsfwcyoamaker.cotdr.resources.Res
import com.nsfwcyoamaker.cotdr.resources.cathedral_bg_preprocessed
import com.nsfwcyoamaker.cotdr.resources.section_followers_title
import com.nsfwcyoamaker.cotdr.resources.title
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
            painter = painterResource(Res.drawable.cathedral_bg_preprocessed),
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
                    style = mainTitleTextStyle,
                )
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                MainIntroduction(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(4.dp)) }

            item {
                SectionTitle(
                    title = stringResource(Res.string.section_followers_title),
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(4.dp)) }

            item {
                PriestessIntroductionDescription(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item {
                PriestessesIntroductionGrid(
                    Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item {
                PriestessIntroductionExtra(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item {
                PriestessIntroductionInterlude(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item {
                PriestessIntroductionExtra2(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            //TODO

            item { Spacer(modifier = Modifier.height(260.dp)) }
        }
    }
}