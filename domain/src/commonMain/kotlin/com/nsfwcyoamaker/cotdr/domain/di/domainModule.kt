package com.nsfwcyoamaker.cotdr.domain.di

import com.nsfwcyoamaker.cotdr.domain.engine.di.engineModule
import com.nsfwcyoamaker.cotdr.domain.engine.repository.ChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GlobalScoreRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.registry.StaticChoiceRegistry
import com.nsfwcyoamaker.cotdr.domain.registry.StaticGlobalScoreRuleRegistry
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun domainModule() = module {
    includes(engineModule())

    single<ChoiceRegistry> { StaticChoiceRegistry }
    single<GlobalScoreRuleRegistry> { StaticGlobalScoreRuleRegistry }

    factoryOf(::GetCurrentConsortsFlowUseCase)
}