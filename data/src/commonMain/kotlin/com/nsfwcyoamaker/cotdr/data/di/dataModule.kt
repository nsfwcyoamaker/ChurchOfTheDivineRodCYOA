package com.nsfwcyoamaker.cotdr.data.di

import com.nsfwcyoamaker.cotdr.data.repository.GameStateRepositoryImpl
import com.nsfwcyoamaker.cotdr.domain.engine.repository.GameStateRepository
import org.koin.dsl.module

fun dataModule() = module {
    single<GameStateRepository> { GameStateRepositoryImpl() }
}