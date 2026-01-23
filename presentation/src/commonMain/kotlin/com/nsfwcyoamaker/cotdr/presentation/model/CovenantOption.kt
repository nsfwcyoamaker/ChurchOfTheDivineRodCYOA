package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Covenant
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class CovenantOption(
    override val choice: Covenant,
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
): UiOption {
    TheHorn(
        Covenant.TheHorn,
        Res.string.covenants_the_horn_title,
        Res.string.covenants_the_horn_description,
        Res.drawable.covenants_the_horn,
    ),
    TheInn(
        Covenant.TheInn,
        Res.string.covenants_the_inn_title,
        Res.string.covenants_the_inn_description,
        Res.drawable.covenants_the_inn,
    ),
    TheFeast(
        Covenant.TheFeast,
        Res.string.covenants_the_feast_title,
        Res.string.covenants_the_feast_description,
        Res.drawable.covenants_the_feast,
    ),
    TheSpectrum(
        Covenant.TheSpectrum,
        Res.string.covenants_the_spectrum_title,
        Res.string.covenants_the_spectrum_description,
        Res.drawable.covenants_the_spectrum,
    ),
    Inversion(
        Covenant.Inversion,
        Res.string.covenants_inversion_title,
        Res.string.covenants_inversion_description,
        Res.drawable.covenants_inversion,
    ),
    Kin(
        Covenant.Kin,
        Res.string.covenants_kin_title,
        Res.string.covenants_kin_description,
        Res.drawable.covenants_kin,
    ),
    TheForge(
        Covenant.TheForge,
        Res.string.covenants_the_forge_title,
        Res.string.covenants_the_forge_description,
        Res.drawable.covenants_the_forge,
    ),
    TheChalice(
        Covenant.TheChalice,
        Res.string.covenants_the_chalice_title,
        Res.string.covenants_the_chalice_description,
        Res.drawable.covenants_the_chalice,
    ),
    Purification(
        Covenant.Purification,
        Res.string.covenants_purification_title,
        Res.string.covenants_purification_description,
        Res.drawable.covenants_purification,
    ),
    TheBlossom(
        Covenant.TheBlossom,
        Res.string.covenants_the_blossom_title,
        Res.string.covenants_the_blossom_description,
        Res.drawable.covenants_the_blossom,
    ),
    TheFountain(
        Covenant.TheFountain,
        Res.string.covenants_the_fountain_title,
        Res.string.covenants_the_fountain_description,
        Res.drawable.covenants_the_fountain,
    ),
    Welcome(
        Covenant.Welcome,
        Res.string.covenants_welcome_title,
        Res.string.covenants_welcome_description,
        Res.drawable.covenants_welcome,
    ),
    TheCaress(
        Covenant.TheCaress,
        Res.string.covenants_the_caress_title,
        Res.string.covenants_the_caress_description,
        Res.drawable.covenants_the_caress,
    ),
    Breath(
        Covenant.Breath,
        Res.string.covenants_breath_title,
        Res.string.covenants_breath_description,
        Res.drawable.covenants_breath,
    ),
    ThePearl(
        Covenant.ThePearl,
        Res.string.covenants_the_pearl_title,
        Res.string.covenants_the_pearl_description,
        Res.drawable.covenants_the_pearl,
    ),
    Bindings(
        Covenant.Bindings,
        Res.string.covenants_bindings_title,
        Res.string.covenants_bindings_description,
        Res.drawable.covenants_bindings,
    ),
    ThePromise(
        Covenant.ThePromise,
        Res.string.covenants_the_promise_title,
        Res.string.covenants_the_promise_description,
        Res.drawable.covenants_the_promise,
    ),
    TheTamer(
        Covenant.TheTamer,
        Res.string.covenants_the_tamer_title,
        Res.string.covenants_the_tamer_description,
        Res.drawable.covenants_the_tamer,
    );
}
