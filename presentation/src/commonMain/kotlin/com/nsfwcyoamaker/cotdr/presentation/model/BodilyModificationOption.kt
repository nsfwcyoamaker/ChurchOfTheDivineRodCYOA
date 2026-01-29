package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class BodilyModificationOption(
    override val choice: BodilyModification,
    val title: StringResource,
    val description: StringResource,
    val cost: StringResource,
    val image: DrawableResource,
): UiOption {
    data object BodyRemodeling: BodilyModificationOption(
        BodilyModification.BodyRemodeling,
        Res.string.mod_body_remodeling_title,
        Res.string.mod_body_remodeling_desc,
        Res.string.mod_body_remodeling_cost,
        Res.drawable.mod_body_remodeling,
    )
    data object DualWield: BodilyModificationOption(
        BodilyModification.DualWield,
        Res.string.mod_dual_wield_title,
        Res.string.mod_dual_wield_desc,
        Res.string.mod_dual_wield_cost,
        Res.drawable.mod_dual_wield,
    )
    data object Zweihander: BodilyModificationOption(
        BodilyModification.Zweihander,
        Res.string.mod_zweihander_title,
        Res.string.mod_zweihander_desc,
        Res.string.mod_zweihander_cost,
        Res.drawable.mod_zweihander,
    )
    data object Miniature: BodilyModificationOption(
        BodilyModification.Miniature,
        Res.string.mod_miniature_title,
        Res.string.mod_miniature_desc,
        Res.string.mod_miniature_cost,
        Res.drawable.mod_miniature,
    ), UiOption.UpgradableUiOption {
        override val upgradeText: StringResource = Res.string.mod_make_permanent
    }
    data object Towering: BodilyModificationOption(
        BodilyModification.Towering,
        Res.string.mod_towering_title,
        Res.string.mod_towering_desc,
        Res.string.mod_towering_cost,
        Res.drawable.mod_towering,
    ), UiOption.UpgradableUiOption {
        override val upgradeText: StringResource = Res.string.mod_make_permanent
    }
    data object AmplifiedTouch: BodilyModificationOption(
        BodilyModification.AmplifiedTouch,
        Res.string.mod_amplified_touch_title,
        Res.string.mod_amplified_touch_desc,
        Res.string.mod_amplified_touch_cost,
        Res.drawable.mod_amplified_touch,
    )
    data object AllIn: BodilyModificationOption(
        BodilyModification.AllIn,
        Res.string.mod_all_in_title,
        Res.string.mod_all_in_desc,
        Res.string.mod_all_in_cost,
        Res.drawable.mod_all_in,
    )
    data object Synchronized: BodilyModificationOption(
        BodilyModification.Synchronized,
        Res.string.mod_synchronized_title,
        Res.string.mod_synchronized_desc,
        Res.string.mod_synchronized_cost,
        Res.drawable.mod_synchronized,
    )
    data object MaximumLoad: BodilyModificationOption(
        BodilyModification.MaximumLoad,
        Res.string.mod_maximum_load_title,
        Res.string.mod_maximum_load_desc,
        Res.string.mod_maximum_load_cost,
        Res.drawable.mod_maximum_load,
    )
    data object Tenfold: BodilyModificationOption(
        BodilyModification.Tenfold,
        Res.string.mod_tenfold_title,
        Res.string.mod_tenfold_desc,
        Res.string.mod_tenfold_cost,
        Res.drawable.mod_tenfold,
    )
    data object SuperArmor: BodilyModificationOption(
        BodilyModification.SuperArmor,
        Res.string.mod_super_armor_title,
        Res.string.mod_super_armor_desc,
        Res.string.mod_super_armor_cost,
        Res.drawable.mod_super_armor,
    )
    data object VastDepths: BodilyModificationOption(
        BodilyModification.VastDepths,
        Res.string.mod_vast_depths_title,
        Res.string.mod_vast_depths_desc,
        Res.string.mod_vast_depths_cost,
        Res.drawable.mod_vast_depths,
    )
    data object RipAndTear: BodilyModificationOption(
        BodilyModification.RipAndTear,
        Res.string.mod_rip_and_tear_title,
        Res.string.mod_rip_and_tear_desc,
        Res.string.mod_rip_and_tear_cost,
        Res.drawable.mod_rip_and_tear,
    )
    data object AmmoSwitcher: BodilyModificationOption(
        BodilyModification.AmmoSwitcher,
        Res.string.mod_ammo_switcher_title,
        Res.string.mod_ammo_switcher_desc,
        Res.string.mod_ammo_switcher_cost,
        Res.drawable.mod_ammo_switcher,
    )
    data object ComfortLayer: BodilyModificationOption(
        BodilyModification.ComfortLayer,
        Res.string.mod_comfort_layer_title,
        Res.string.mod_comfort_layer_desc,
        Res.string.mod_comfort_layer_cost,
        Res.drawable.mod_comfort_layer,
    )
    data object GroupDynamic: BodilyModificationOption(
        BodilyModification.GroupDynamic,
        Res.string.mod_group_dynamic_title,
        Res.string.mod_group_dynamic_desc,
        Res.string.mod_group_dynamic_cost,
        Res.drawable.mod_group_dynamic,
    )
    data object SustainedHeights: BodilyModificationOption(
        BodilyModification.SustainedHeights,
        Res.string.mod_sustained_highs_title,
        Res.string.mod_sustained_highs_desc,
        Res.string.mod_sustained_highs_cost,
        Res.drawable.mod_sustained_highs,
    )
    data object Rapunzel: BodilyModificationOption(
        BodilyModification.Rapunzel,
        Res.string.mod_rapunzel_title,
        Res.string.mod_rapunzel_desc,
        Res.string.mod_rapunzel_cost,
        Res.drawable.mod_rapunzel,
    )

    companion object {
        val all = listOf(
            BodyRemodeling,
            DualWield,
            Zweihander,
            Miniature,
            Towering,
            AmplifiedTouch,
            AllIn,
            Synchronized,
            MaximumLoad,
            Tenfold,
            SuperArmor,
            VastDepths,
            RipAndTear,
            AmmoSwitcher,
            ComfortLayer,
            GroupDynamic,
            SustainedHeights,
            Rapunzel,
        )
    }
}