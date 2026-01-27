package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Brand
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class BrandOption(
    override val choice: Brand,
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
): UiOption {
    /*
    Womb(
        choice = Brand.Womb,
        title = Res.string.brands_womb_title,
        description = Res.string.brands_womb_description,
        image = Res.drawable.brands_womb,
    ),
    Stomach,
    Back,
    LowerBack,
    Ass,
    Anus,
    Breast,
    Cleavage,
    Nipple,
    Chest,
    Arm,
    Hand,
    Neck,
    Face,
    Tongue,
    Garter,
    Underside,
    Sides,
    InnerThigh,
    Hip,
    Foot;

     */
}