package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class BodilyModificationOption(
    override val choice: BodilyModification,
    val title: StringResource,
    val description: StringResource,
    val cost: StringResource,
    val image: DrawableResource,
    val upgradeText: StringResource? = null,
): UiOption {
    BodyRemodeling(
        BodilyModification.BodyRemodeling,
        Res.string.mod_body_remodeling_title,
        Res.string.mod_body_remodeling_desc,
        Res.string.mod_body_remodeling_cost,
        Res.drawable.mod_body_remodeling,
    ),
    DualWield(
        BodilyModification.DualWield,
        Res.string.mod_dual_wield_title,
        Res.string.mod_dual_wield_desc,
        Res.string.mod_dual_wield_cost,
        Res.drawable.mod_dual_wield,
    ),
    Zweihander(
        BodilyModification.Zweihander,
        Res.string.mod_zweihander_title,
        Res.string.mod_zweihander_desc,
        Res.string.mod_zweihander_cost,
        Res.drawable.mod_zweihander,
    ),
    Miniature(
        BodilyModification.Miniature,
        Res.string.mod_miniature_title,
        Res.string.mod_miniature_desc,
        Res.string.mod_miniature_cost,
        Res.drawable.mod_miniature,
        Res.string.mod_make_permanent,
    ),
    Towering(
        BodilyModification.Towering,
        Res.string.mod_towering_title,
        Res.string.mod_towering_desc,
        Res.string.mod_towering_cost,
        Res.drawable.mod_towering,
        Res.string.mod_make_permanent,
    ),
    AmplifiedTouch(
        BodilyModification.AmplifiedTouch,
        Res.string.mod_amplified_touch_title,
        Res.string.mod_amplified_touch_desc,
        Res.string.mod_amplified_touch_cost,
        Res.drawable.mod_amplified_touch,
    ),
    AllIn(
        BodilyModification.AllIn,
        Res.string.mod_all_in_title,
        Res.string.mod_all_in_desc,
        Res.string.mod_all_in_cost,
        Res.drawable.mod_all_in,
    ),
    Synchronized(
        BodilyModification.Synchronized,
        Res.string.mod_synchronized_title,
        Res.string.mod_synchronized_desc,
        Res.string.mod_synchronized_cost,
        Res.drawable.mod_synchronized,
    ),
    MaximumLoad(
        BodilyModification.MaximumLoad,
        Res.string.mod_maximum_load_title,
        Res.string.mod_maximum_load_desc,
        Res.string.mod_maximum_load_cost,
        Res.drawable.mod_maximum_load,
    ),
    Tenfold(
        BodilyModification.Tenfold,
        Res.string.mod_tenfold_title,
        Res.string.mod_tenfold_desc,
        Res.string.mod_tenfold_cost,
        Res.drawable.mod_tenfold,
    ),
    SuperArmor(
        BodilyModification.SuperArmor,
        Res.string.mod_super_armor_title,
        Res.string.mod_super_armor_desc,
        Res.string.mod_super_armor_cost,
        Res.drawable.mod_super_armor,
    ),
    VastDepths(
        BodilyModification.VastDepths,
        Res.string.mod_vast_depths_title,
        Res.string.mod_vast_depths_desc,
        Res.string.mod_vast_depths_cost,
        Res.drawable.mod_vast_depths,
    ),
    RipAndTear(
        BodilyModification.RipAndTear,
        Res.string.mod_rip_and_tear_title,
        Res.string.mod_rip_and_tear_desc,
        Res.string.mod_rip_and_tear_cost,
        Res.drawable.mod_rip_and_tear,
    ),
    AmmoSwitcher(
        BodilyModification.AmmoSwitcher,
        Res.string.mod_ammo_switcher_title,
        Res.string.mod_ammo_switcher_desc,
        Res.string.mod_ammo_switcher_cost,
        Res.drawable.mod_ammo_switcher,
    ),
    ComfortLayer(
        BodilyModification.ComfortLayer,
        Res.string.mod_comfort_layer_title,
        Res.string.mod_comfort_layer_desc,
        Res.string.mod_comfort_layer_cost,
        Res.drawable.mod_comfort_layer,
    ),
    GroupDynamic(
        BodilyModification.GroupDynamic,
        Res.string.mod_group_dynamic_title,
        Res.string.mod_group_dynamic_desc,
        Res.string.mod_group_dynamic_cost,
        Res.drawable.mod_group_dynamic,
    ),
    SustainedHeights(
        BodilyModification.SustainedHeights,
        Res.string.mod_sustained_highs_title,
        Res.string.mod_sustained_highs_desc,
        Res.string.mod_sustained_highs_cost,
        Res.drawable.mod_sustained_highs,
    ),
    Rapunzel(
        BodilyModification.Rapunzel,
        Res.string.mod_rapunzel_title,
        Res.string.mod_rapunzel_desc,
        Res.string.mod_rapunzel_cost,
        Res.drawable.mod_rapunzel,
    );
}