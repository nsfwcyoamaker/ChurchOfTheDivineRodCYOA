package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.components.main.CathedralBackground
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainIntroduction
import com.nsfwcyoamaker.cotdr.presentation.components.main.MainTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorDescription
import com.nsfwcyoamaker.cotdr.presentation.components.sections.fervor.FervorTitle
import com.nsfwcyoamaker.cotdr.presentation.components.sections.priestesses_introduction.*
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
        CathedralBackground(
            Modifier.fillMaxSize(),
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                MainTitle(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp)
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
                PriestessesIntroductionTitle(
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

            item { Spacer(modifier = Modifier.height(60.dp)) }

            item {
                FervorTitle(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp),
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item {
                FervorDescription(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .padding(horizontal = 80.dp)
                )
            }

            item { Spacer(modifier = Modifier.height(6.dp)) }

            item { Spacer(modifier = Modifier.height(260.dp)) }
        }
    }
}