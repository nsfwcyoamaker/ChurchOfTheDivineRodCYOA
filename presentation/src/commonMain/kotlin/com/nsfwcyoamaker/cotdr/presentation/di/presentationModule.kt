package com.nsfwcyoamaker.cotdr.presentation.di

import com.nsfwcyoamaker.cotdr.presentation.screens.MainScreenModel
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.bodily_modifications.BodilyModificationsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.church_appeal.ChurchAppealSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts.ConsortsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contract_conduct.ContractConductsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.contracts.ContractsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.covenants.CovenantsSelectionViewModel
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionViewModel
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
    factoryOf(::ExperimentalBrandsSelectionViewModel)
    factoryOf(::ExperimentalBrandsSelectionActionDependencies)
    factoryOf(::ContractsSelectionViewModel)
    factoryOf(::ContractsSelectionActionDependencies)
    factoryOf(::ContractConductsSelectionViewModel)
    factoryOf(::ContractConductsSelectionActionDependencies)
    factoryOf(::ChurchAppealSelectionViewModel)
    factoryOf(::ChurchAppealSelectionActionDependencies)
}