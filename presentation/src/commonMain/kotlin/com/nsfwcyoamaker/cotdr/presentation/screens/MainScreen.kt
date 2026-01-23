package com.nsfwcyoamaker.cotdr.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.nsfwcyoamaker.cotdr.presentation.components.main.CyoaBottomBar
import com.nsfwcyoamaker.cotdr.presentation.components.pages.MainPage1
import com.nsfwcyoamaker.cotdr.presentation.components.pages.MainPage2
import com.nsfwcyoamaker.cotdr.presentation.components.pages.MainPage3

object MainScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<MainScreenModel>()

        val fervor by screenModel.totalFervorFlow.collectAsState()
        val consortsState by screenModel.consortsState.collectAsState()
        val bodilyModificationsState by screenModel.bodilyModificationsState.collectAsState()
        val covenantState by screenModel.covenantsState.collectAsState()

        Scaffold(
            containerColor = Color.Transparent,
            bottomBar = { CyoaBottomBar(currentFervor = fervor) }
        ) {
            MainScreenList {
                MainPage1(
                    consortsState = consortsState,
                    onConsortsAction = screenModel::runConsortsAction,
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage2(
                    bodilyModificationsState = bodilyModificationsState,
                    onBodilyModificationAction = screenModel::runBodilyModificationsAction,
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                MainPage3(
                    covenantState = covenantState,
                    onCovenantsAction = screenModel::runCovenantsAction,
                )
                item { Spacer(modifier = Modifier.height(60.dp)) }
                //TODO
            }
        }
    }
}