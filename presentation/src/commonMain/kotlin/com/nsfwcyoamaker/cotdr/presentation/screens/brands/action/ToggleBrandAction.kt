package com.nsfwcyoamaker.cotdr.presentation.screens.brands.action

import com.nsfwcyoamaker.cotdr.domain.model.Brand
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.brands.BrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class ToggleBrandAction(
    val brandOption: Brand,
): BrandsSelectionAction {
    override suspend fun execute(
        dependencies: BrandsSelectionActionDependencies,
        scope: ActionScope<BrandsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(brandOption)
    }
}