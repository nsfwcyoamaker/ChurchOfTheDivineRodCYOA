package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsfwcyoamaker.cotdr.presentation.components.pages.MainPage1
import com.nsfwcyoamaker.cotdr.presentation.components.pages.MainPage2

@Composable
fun MainScreen() {
    val itemsModifier = Modifier
        .fillMaxWidth(0.95f)
        .padding(horizontal = 80.dp)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        item { Spacer(modifier = Modifier.height(60.dp)) }
        MainPage1(itemsModifier)
        item { Spacer(modifier = Modifier.height(60.dp)) }
        MainPage2(itemsModifier)
        item { Spacer(modifier = Modifier.height(60.dp)) }
        // todo
        item { Spacer(modifier = Modifier.height(260.dp)) }
    }
}