package com.nsfwcyoamaker.cotdr.domain.di

import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentBodilyModificationsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetTotalFervorFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.ToggleConsortUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun domainModule() = module {
    factoryOf(::GetTotalFervorFlowUseCase)

    factoryOf(::GetCurrentConsortsFlowUseCase)
    factoryOf(::ToggleConsortUseCase)

    factoryOf(::GetCurrentBodilyModificationsFlowUseCase)
}