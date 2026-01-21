package com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection

import com.nsfwcyoamaker.cotdr.domain.model.Priestess
import com.nsfwcyoamaker.cotdr.domain.usecase.GetCurrentConsortsFlowUseCase
import com.nsfwcyoamaker.cotdr.domain.usecase.ToggleConsortUseCase
import com.nsfwcyoamaker.cotdr.presentation.model.PriestessIntroductionOption
import com.nsfwcyoamaker.cotdr.presentation.screens.consorts_selection.action.ObserveRepoState
import com.nsfwcyoamaker.cotdr.presentationToadHandler.ToadViewModel
import kotlinx.coroutines.CoroutineScope

class ConsortsSelectionViewModel(
    private val scope: CoroutineScope,
    private val getCurrentConsortsFlowUseCase: GetCurrentConsortsFlowUseCase,
    private val toggleConsortUseCase: ToggleConsortUseCase,
): ToadViewModel<ConsortsSelectionState, Nothing>(
    initialState = ConsortsSelectionState(),
    scope = scope,
) {
    override val dependencies = ConsortsSelectionActionDependencies(
        scope,
        getCurrentConsortsFlowUseCase,
        toggleConsortUseCase,
    )

    init {
        dispatch(ObserveRepoState)
    }

    fun runAction(action: ConsortsSelectionAction) {
        dispatch(action)
    }

    companion object {
        fun PriestessIntroductionOption.toPriestess(): Priestess? {
            return when (this) {
                PriestessIntroductionOption.Acerola -> Priestess.Acerola
                PriestessIntroductionOption.Celeste -> Priestess.Celeste
                PriestessIntroductionOption.Desuri -> Priestess.Desuri
                PriestessIntroductionOption.Erina -> Priestess.Erina
                PriestessIntroductionOption.Helena -> Priestess.Helena
                PriestessIntroductionOption.Consorts -> null
            }
        }

        fun Priestess.toPriestessIntroductionOption(): PriestessIntroductionOption {
            return when (this) {
                Priestess.Acerola -> PriestessIntroductionOption.Acerola
                Priestess.Celeste -> PriestessIntroductionOption.Celeste
                Priestess.Desuri -> PriestessIntroductionOption.Desuri
                Priestess.Erina -> PriestessIntroductionOption.Erina
                Priestess.Helena -> PriestessIntroductionOption.Helena
            }
        }
    }
}