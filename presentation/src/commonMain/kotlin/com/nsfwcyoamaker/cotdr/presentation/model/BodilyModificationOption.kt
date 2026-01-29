package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.BodilyModification
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed interface BodilyModificationOption: UiOption {
    override val choice: BodilyModification
    val title: StringResource
    val description: StringResource
    val cost: StringResource
    val image: DrawableResource

    sealed interface Upgradable: BodilyModificationOption {
        override val choice: BodilyModification.Upgradable
    }

    data object BodyRemodeling: BodilyModificationOption {
        override val choice = BodilyModification.BodyRemodeling
        override val title = Res.string.mod_body_remodeling_title
        override val description = Res.string.mod_body_remodeling_desc
        override val cost = Res.string.mod_body_remodeling_cost
        override val image = Res.drawable.mod_body_remodeling
    }
    data object DualWield: BodilyModificationOption {
        override val choice = BodilyModification.DualWield
        override val title = Res.string.mod_dual_wield_title
        override val description = Res.string.mod_dual_wield_desc
        override val cost = Res.string.mod_dual_wield_cost
        override val image = Res.drawable.mod_dual_wield
    }
    data object Zweihander: BodilyModificationOption {
        override val choice = BodilyModification.Zweihander
        override val title = Res.string.mod_zweihander_title
        override val description = Res.string.mod_zweihander_desc
        override val cost = Res.string.mod_zweihander_cost
        override val image = Res.drawable.mod_zweihander
    }
    data object Miniature: Upgradable, UiOption.UpgradableUiOption {
        override val choice = BodilyModification.Miniature
        override val title = Res.string.mod_miniature_title
        override val description = Res.string.mod_miniature_desc
        override val cost = Res.string.mod_miniature_cost
        override val image = Res.drawable.mod_miniature
        override val upgradeText = Res.string.mod_make_permanent
    }
    data object Towering: Upgradable, UiOption.UpgradableUiOption {
        override val choice = BodilyModification.Towering
        override val title = Res.string.mod_towering_title
        override val description = Res.string.mod_towering_desc
        override val cost = Res.string.mod_towering_cost
        override val image = Res.drawable.mod_towering
        override val upgradeText = Res.string.mod_make_permanent
    }
    data object AmplifiedTouch: BodilyModificationOption {
        override val choice = BodilyModification.AmplifiedTouch
        override val title = Res.string.mod_amplified_touch_title
        override val description = Res.string.mod_amplified_touch_desc
        override val cost = Res.string.mod_amplified_touch_cost
        override val image = Res.drawable.mod_amplified_touch
    }
    data object AllIn: BodilyModificationOption {
        override val choice = BodilyModification.AllIn
        override val title = Res.string.mod_all_in_title
        override val description = Res.string.mod_all_in_desc
        override val cost = Res.string.mod_all_in_cost
        override val image = Res.drawable.mod_all_in
    }
    data object Synchronized: BodilyModificationOption {
        override val choice = BodilyModification.Synchronized
        override val title = Res.string.mod_synchronized_title
        override val description = Res.string.mod_synchronized_desc
        override val cost = Res.string.mod_synchronized_cost
        override val image = Res.drawable.mod_synchronized
    }
    data object MaximumLoad: BodilyModificationOption {
        override val choice = BodilyModification.MaximumLoad
        override val title = Res.string.mod_maximum_load_title
        override val description = Res.string.mod_maximum_load_desc
        override val cost = Res.string.mod_maximum_load_cost
        override val image = Res.drawable.mod_maximum_load
    }
    data object Tenfold: BodilyModificationOption {
        override val choice = BodilyModification.Tenfold
        override val title = Res.string.mod_tenfold_title
        override val description = Res.string.mod_tenfold_desc
        override val cost = Res.string.mod_tenfold_cost
        override val image = Res.drawable.mod_tenfold
    }
    data object SuperArmor: BodilyModificationOption {
        override val choice = BodilyModification.SuperArmor
        override val title = Res.string.mod_super_armor_title
        override val description = Res.string.mod_super_armor_desc
        override val cost = Res.string.mod_super_armor_cost
        override val image = Res.drawable.mod_super_armor
    }
    data object VastDepths: BodilyModificationOption {
        override val choice = BodilyModification.VastDepths
        override val title = Res.string.mod_vast_depths_title
        override val description = Res.string.mod_vast_depths_desc
        override val cost = Res.string.mod_vast_depths_cost
        override val image = Res.drawable.mod_vast_depths
    }
    data object RipAndTear: BodilyModificationOption {
        override val choice = BodilyModification.RipAndTear
        override val title = Res.string.mod_rip_and_tear_title
        override val description = Res.string.mod_rip_and_tear_desc
        override val cost = Res.string.mod_rip_and_tear_cost
        override val image = Res.drawable.mod_rip_and_tear
    }
    data object AmmoSwitcher: BodilyModificationOption {
        override val choice = BodilyModification.AmmoSwitcher
        override val title = Res.string.mod_ammo_switcher_title
        override val description = Res.string.mod_ammo_switcher_desc
        override val cost = Res.string.mod_ammo_switcher_cost
        override val image = Res.drawable.mod_ammo_switcher
    }
    data object ComfortLayer: BodilyModificationOption {
        override val choice = BodilyModification.ComfortLayer
        override val title = Res.string.mod_comfort_layer_title
        override val description = Res.string.mod_comfort_layer_desc
        override val cost = Res.string.mod_comfort_layer_cost
        override val image = Res.drawable.mod_comfort_layer
    }
    data object GroupDynamic: BodilyModificationOption {
        override val choice = BodilyModification.GroupDynamic
        override val title = Res.string.mod_group_dynamic_title
        override val description = Res.string.mod_group_dynamic_desc
        override val cost = Res.string.mod_group_dynamic_cost
        override val image = Res.drawable.mod_group_dynamic
    }
    data object SustainedHeights: BodilyModificationOption {
        override val choice = BodilyModification.SustainedHeights
        override val title = Res.string.mod_sustained_highs_title
        override val description = Res.string.mod_sustained_highs_desc
        override val cost = Res.string.mod_sustained_highs_cost
        override val image = Res.drawable.mod_sustained_highs
    }
    data object Rapunzel: BodilyModificationOption {
        override val choice = BodilyModification.Rapunzel
        override val title = Res.string.mod_rapunzel_title
        override val description = Res.string.mod_rapunzel_desc
        override val cost = Res.string.mod_rapunzel_cost
        override val image = Res.drawable.mod_rapunzel
    }

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