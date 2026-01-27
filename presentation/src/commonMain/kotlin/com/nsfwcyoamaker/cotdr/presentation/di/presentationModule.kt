package com.nsfwcyoamaker.cotdr.presentation.di

import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenModel
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun presentationModule() = module {
    factoryOf(::MainScreenModel)
    factoryOf(::ConsortsSelectionViewModel)
    factoryOf(::BodilyModificationsSelectionViewModel)
    factoryOf(::BodilyModificationsSelectionActionDependencies)
    factoryOf(::CovenantsSelectionViewModel)
    factoryOf(::CovenantsSelectionActionDependencies)
    factoryOf(::BrandsSelectionViewModel)
    factoryOf(::BrandsSelectionActionDependencies)
}