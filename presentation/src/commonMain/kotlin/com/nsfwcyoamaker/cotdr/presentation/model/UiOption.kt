package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Choice
import org.jetbrains.compose.resources.StringResource

interface UiOption {
    val choice: Choice

    interface UpgradableUiOption: UiOption {
        val upgradeText: StringResource
    }
}