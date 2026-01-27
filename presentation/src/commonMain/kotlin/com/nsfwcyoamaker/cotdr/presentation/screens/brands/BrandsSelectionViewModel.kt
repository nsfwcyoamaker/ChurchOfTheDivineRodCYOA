package com.nsfwcyoamaker.cotdr.presentation.screens.brands

import com.nsfwcyoamaker.cotdr.presentation.screens.brands.action.ObserveBrandsAction
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class BrandsSelectionViewModel(
    private val scope: CoroutineScope,
): KoinComponent, ToadViewModel<BrandsSelectionState, Nothing>(
    initialState = BrandsSelectionState(),
    scope = scope,
) {
    override val dependencies by inject<BrandsSelectionActionDependencies> { parametersOf(scope) }

    init {
        dispatch(ObserveBrandsAction)
    }

    fun runAction(action: BrandsSelectionAction) {
        dispatch(action)
    }
}