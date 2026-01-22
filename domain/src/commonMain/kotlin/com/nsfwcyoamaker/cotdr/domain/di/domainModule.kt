package com.nsfwcyoamaker.cotdr.domain.di

import com.nsfwcyoamaker.cotdr.domain.usecase.*
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun domainModule() = module {
    factoryOf(::GetCurrentChoicesFlowUseCase)
    factoryOf(::GetTotalFervorFlowUseCase)

    factoryOf(::GetCurrentConsortsFlowUseCase)
    factoryOf(::ToggleConsortUseCase)

    factoryOf(::FilterOnlyBodilyModificationsUseCase)
    factoryOf(::GetCurrentBodilyModificationsFlowUseCase)
    factoryOf(::BodilyModificationClickedUseCase)
    factoryOf(::UpgradeBodilyModificationClickedUseCase)
    factoryOf(::IncreaseBodilyModificationBuyTimesUseCase)
    factoryOf(::DecreaseBodilyModificationBuyTimesUseCase)
}