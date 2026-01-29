package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import com.nsfwcyoamaker.cotdr.domain.engine.model.UpgradableChoice
import org.jetbrains.compose.resources.StringResource

interface UiOption {
    val choice: Choice

    interface UpgradableUiOption: UiOption {
        override val choice: UpgradableChoice
        val upgradeText: StringResource
    }
}