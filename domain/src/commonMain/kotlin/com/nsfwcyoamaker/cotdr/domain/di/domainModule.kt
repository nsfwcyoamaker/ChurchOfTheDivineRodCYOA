package com.nsfwcyoamaker.cotdr.domain.di

import com.nsfwcyoamaker.cotdr.domain.engine.di.engineModule
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.registry.StaticChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.registry.StaticGlobalRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.usecase.FilterOnlyBodilyModificationsUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentBodilyModificationsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun domainModule() = module {
    includes(engineModule())

    single<ChoiceRegistry> { StaticChoiceRegistry }
    single<GlobalRuleRegistry> { StaticGlobalRuleRegistry }

    factoryOf(::FilterOnlyBodilyModificationsUseCase)
    factoryOf(::GetCurrentBodilyModificationsFlowUseCase)
    factoryOf(::GetCurrentConsortsFlowUseCase)
}