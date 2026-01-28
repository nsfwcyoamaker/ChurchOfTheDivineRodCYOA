package com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands

import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.action.ObserveExperimentalBrandsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ExperimentalBrandsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<ExperimentalBrandsSelectionState, Nothing>(
    initialState = ExperimentalBrandsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<ExperimentalBrandsSelectionActionDependencies> { parametersOf(scope) }

    init {
        dispatch(ObserveExperimentalBrandsAction)
    }

    fun runAction(action: ExperimentalBrandsSelectionAction) {
        dispatch(action)
    }
}