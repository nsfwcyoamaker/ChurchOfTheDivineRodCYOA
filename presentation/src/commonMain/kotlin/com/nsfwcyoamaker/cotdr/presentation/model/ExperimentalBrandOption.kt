package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.ExperimentalBrand
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ExperimentalBrandOption(
    override val choice: ExperimentalBrand,
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource?,
): UiOption {
    Pupil(
        choice = ExperimentalBrand.Pupil,
        title = Res.string.experimental_brands_pupil_title,
        description = Res.string.experimental_brands_pupil_description,
        image = Res.drawable.experimental_brands_pupil,
    ),
    Egg(
        choice = ExperimentalBrand.Egg,
        title = Res.string.experimental_brands_egg_title,
        description = Res.string.experimental_brands_egg_description,
        image = Res.drawable.experimental_brands_egg,
    ),
    Hair(
        choice = ExperimentalBrand.Hair,
        title = Res.string.experimental_brands_hair_title,
        description = Res.string.experimental_brands_hair_description,
        image = Res.drawable.experimental_brands_hair,
    ),
    Pussy(
        choice = ExperimentalBrand.Pussy,
        title = Res.string.experimental_brands_pussy_title,
        description = Res.string.experimental_brands_pussy_description,
        image = Res.drawable.experimental_brands_pussy,
    ),
    Piercings(
        choice = ExperimentalBrand.Piercings,
        title = Res.string.experimental_brands_piercings_title,
        description = Res.string.experimental_brands_piercings_description,
        image = Res.drawable.experimental_brands_piercings,
    ),
    Minimal(
        choice = ExperimentalBrand.Minimal,
        title = Res.string.experimental_brands_minimal_title,
        description = Res.string.experimental_brands_minimal_description,
        image = Res.drawable.experimental_brands_minimal,
    ),
    Light(
        choice = ExperimentalBrand.Light,
        title = Res.string.experimental_brands_light_title,
        description = Res.string.experimental_brands_light_description,
        image = Res.drawable.experimental_brands_light,
    ),
    Talisman(
        choice = ExperimentalBrand.Talisman,
        title = Res.string.experimental_brands_talisman_title,
        description = Res.string.experimental_brands_talisman_description,
        image = Res.drawable.experimental_brands_talisman,
    ),
    Marking(
        choice = ExperimentalBrand.Marking,
        title = Res.string.experimental_brands_talisman_title,
        description = Res.string.experimental_brands_talisman_description,
        image = Res.drawable.experimental_brands_talisman,
    );
}