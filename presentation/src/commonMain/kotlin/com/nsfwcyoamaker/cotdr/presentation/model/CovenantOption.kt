package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Covenant
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class CovenantOption(
    override val choice: Covenant,
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
): UiOption {

/*
    TheHorn(
        Covenant.TheHorn,

    ),
    TheInn,
    TheFeast,
    TheSpectrum,
    Inversion,
    Kin,
    TheForge,
    TheChalice,
    Purification,
    TheBlossom,
    TheFountain,
    Welcome,
    TheCaress,
    Breath,
    ThePearl,
    Bindings,
    ThePromise,
    TheTamer;
 */
}
