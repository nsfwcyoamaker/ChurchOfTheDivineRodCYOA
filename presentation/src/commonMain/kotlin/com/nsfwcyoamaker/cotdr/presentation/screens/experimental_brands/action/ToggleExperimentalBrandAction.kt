package com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.action

import com.nsfwcyoamaker.cotdr.domain.model.ExperimentalBrand
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionAction
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionActionDependencies
import com.nsfwcyoamaker.cotdr.presentation.screens.experimental_brands.ExperimentalBrandsSelectionState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ActionScope

data class ToggleExperimentalBrandAction(
    val brandOption: ExperimentalBrand,
): ExperimentalBrandsSelectionAction {
    override suspend fun execute(
        dependencies: ExperimentalBrandsSelectionActionDependencies,
        scope: ActionScope<ExperimentalBrandsSelectionState, Nothing>
    ) {
        dependencies.toggleChoiceUseCase(brandOption)
    }
}