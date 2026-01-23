package com.nsfwcyoamaker.cotdr.presentation.di

import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenModel
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.ConsortsSelectionViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun presentationModule() = module {
    factoryOf(::MainScreenModel)
    factoryOf(::ConsortsSelectionViewModel)
    factoryOf(::BodilyModificationsSelectionViewModel)
    factoryOf(::BodilyModificationsSelectionActionDependencies)
}