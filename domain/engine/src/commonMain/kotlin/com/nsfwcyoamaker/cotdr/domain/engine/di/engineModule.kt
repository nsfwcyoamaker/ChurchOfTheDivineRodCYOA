package com.nsfwcyoamaker.cotdr.domain.engine.di

import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateManager
import com.nsfwcyoamaker.cotdr.domain.engine.logic.GameStateValidator
import com.nsfwcyoamaker.cotdr.domain.engine.usecase.*
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun engineModule() = module {
    factoryOf(::GameStateManager)
    factoryOf(::GameStateValidator)

    factoryOf(::GetCurrentChoicesFlowUseCase)
    factoryOf(::GetComputedChoicesUseCase)

    factoryOf(::CalculateTotalScoreUseCase)

    factoryOf(::ToggleChoiceUseCase)
    factoryOf(::ToggleChoiceUpgradeUseCase)
    factoryOf(::DecreaseChoiceBuyTimesUseCase)
    factoryOf(::IncreaseChoiceBuyTimesUseCase)
}