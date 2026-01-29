package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Brand
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class BrandOption(
    override val choice: Brand,
    val title: StringResource,
    val description: StringResource,
    val image: DrawableResource,
): UiOption {
    Womb(
        choice = Brand.Womb,
        title = Res.string.brands_womb_title,
        description = Res.string.brands_womb_description,
        image = Res.drawable.brands_womb,
    ),
    Stomach(
        choice = Brand.Stomach,
        title = Res.string.brands_stomach_title,
        description = Res.string.brands_stomach_description,
        image = Res.drawable.brands_stomach,
    ),
    Back(
        choice = Brand.Back,
        title = Res.string.brands_back_title,
        description = Res.string.brands_back_description,
        image = Res.drawable.brands_back,
    ),
    LowerBack(
        choice = Brand.LowerBack,
        title = Res.string.brands_lower_back_title,
        description = Res.string.brands_lower_back_description,
        image = Res.drawable.brands_lower_back,
    ),
    Ass(
        choice = Brand.Ass,
        title = Res.string.brands_ass_title,
        description = Res.string.brands_ass_description,
        image = Res.drawable.brands_ass,
    ),
    Anus(
        choice = Brand.Anus,
        title = Res.string.brands_anus_title,
        description = Res.string.brands_anus_description,
        image = Res.drawable.brands_anus,
    ),
    Breast(
        choice = Brand.Breast,
        title = Res.string.brands_breast_title,
        description = Res.string.brands_breast_description,
        image = Res.drawable.brands_breast,
    ),
    Cleavage(
        choice = Brand.Cleavage,
        title = Res.string.brands_cleavage_title,
        description = Res.string.brands_cleavage_description,
        image = Res.drawable.brands_cleavage,
    ),
    Nipple(
        choice = Brand.Nipple,
        title = Res.string.brands_nipple_title,
        description = Res.string.brands_nipple_description,
        image = Res.drawable.brands_nipple,
    ),
    Chest(
        choice = Brand.Chest,
        title = Res.string.brands_chest_title,
        description = Res.string.brands_chest_description,
        image = Res.drawable.brands_chest,
    ),
    Arm(
        choice = Brand.Arm,
        title = Res.string.brands_arm_title,
        description = Res.string.brands_arm_description,
        image = Res.drawable.brands_arm,
    ),
    Hand(
        choice = Brand.Hand,
        title = Res.string.brands_hand_title,
        description = Res.string.brands_hand_description,
        image = Res.drawable.brands_hand,
    ),
    Neck(
        choice = Brand.Neck,
        title = Res.string.brands_neck_title,
        description = Res.string.brands_neck_description,
        image = Res.drawable.brands_neck,
    ),
    Face(
        choice = Brand.Face,
        title = Res.string.brands_face_title,
        description = Res.string.brands_face_description,
        image = Res.drawable.brands_face,
    ),
    Tongue(
        choice = Brand.Tongue,
        title = Res.string.brands_tongue_title,
        description = Res.string.brands_tongue_description,
        image = Res.drawable.brands_tongue,
    ),
    Garter(
        choice = Brand.Garter,
        title = Res.string.brands_garter_title,
        description = Res.string.brands_garter_description,
        image = Res.drawable.brands_garter,
    ),
    Underside(
        choice = Brand.Underside,
        title = Res.string.brands_underside_title,
        description = Res.string.brands_underside_description,
        image = Res.drawable.brands_underside,
    ),
    Sides(
        choice = Brand.Sides,
        title = Res.string.brands_sides_title,
        description = Res.string.brands_sides_description,
        image = Res.drawable.brands_sides,
    ),
    InnerThigh(
        choice = Brand.InnerThigh,
        title = Res.string.brands_inner_thigh_title,
        description = Res.string.brands_inner_thigh_description,
        image = Res.drawable.brands_inner_thigh,
    ),
    Hip(
        choice = Brand.Hip,
        title = Res.string.brands_hip_title,
        description = Res.string.brands_hip_description,
        image = Res.drawable.brands_hip,
    ),
    Foot(
        choice = Brand.Foot,
        title = Res.string.brands_foot_title,
        description = Res.string.brands_foot_description,
        image = Res.drawable.brands_foot,
    );
}