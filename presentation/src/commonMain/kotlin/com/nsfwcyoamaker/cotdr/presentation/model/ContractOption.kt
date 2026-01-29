package com.nsfwcyoamaker.cotdr.presentation.model

import com.nsfwcyoamaker.cotdr.domain.model.Contract
import com.nsfwcyoamaker.cotdr.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class ContractOption(
    override val choice: Contract,
    val title: StringResource,
    val description: StringResource,
    val demonImage: DrawableResource,
    val nunImage: DrawableResource,
): UiOption {
    FelicLusch(
        choice = Contract.FelicLusch,
        title = Res.string.contract_felic_lusch_title,
        description = Res.string.contract_felic_lusch_description,
        demonImage = Res.drawable.contract_felic_lusch_demon,
        nunImage = Res.drawable.contract_felic_lusch_nun,
    ),
    Barishi(
        choice = Contract.Barishi,
        title = Res.string.contract_barishi_title,
        description = Res.string.contract_barishi_description,
        demonImage = Res.drawable.contract_barishi_demon,
        nunImage = Res.drawable.contract_barishi_nun
    ),
    Iustitia(
        choice = Contract.Iustitia,
        title = Res.string.contract_iustitia_title,
        description = Res.string.contract_iustitia_description,
        demonImage = Res.drawable.contract_iustitia_demon,
        nunImage = Res.drawable.contract_iustitia_nun
    ),
    Ithaca(
        choice = Contract.Ithaca,
        title = Res.string.contract_ithaca_title,
        description = Res.string.contract_ithaca_description,
        demonImage = Res.drawable.contract_ithaca_demon,
        nunImage = Res.drawable.contract_ithaca_nun
    ),
    Adoria(
        choice = Contract.Adoria,
        title = Res.string.contract_adoria_title,
        description = Res.string.contract_adoria_description,
        demonImage = Res.drawable.contract_adoria_demon,
        nunImage = Res.drawable.contract_adoria_nun
    ),
    Harlan(
        choice = Contract.Harlan,
        title = Res.string.contract_harlan_title,
        description = Res.string.contract_harlan_description,
        demonImage = Res.drawable.contract_harlan_demon,
        nunImage = Res.drawable.contract_harlan_nun
    ),
    Mieru(
        choice = Contract.Mieru,
        title = Res.string.contract_mieru_title,
        description = Res.string.contract_mieru_description,
        demonImage = Res.drawable.contract_mieru_demon,
        nunImage = Res.drawable.contract_mieru_nun
    ),
    Estra(
        choice = Contract.Estra,
        title = Res.string.contract_estra_title,
        description = Res.string.contract_estra_description,
        demonImage = Res.drawable.contract_estra_demon,
        nunImage = Res.drawable.contract_estra_nun
    ),
    Boudica(
        choice = Contract.Boudica,
        title = Res.string.contract_boudica_title,
        description = Res.string.contract_boudica_description,
        demonImage = Res.drawable.contract_boudica_demon,
        nunImage = Res.drawable.contract_boudica_nun
    ),
    KalimEter(
        choice = Contract.KalimEter,
        title = Res.string.contract_kalim_eter_title,
        description = Res.string.contract_kalim_eter_description,
        demonImage = Res.drawable.contract_kalim_eter_demon,
        nunImage = Res.drawable.contract_kalim_eter_nun
    ),
    Virgo(
        choice = Contract.Virgo,
        title = Res.string.contract_virgo_title,
        description = Res.string.contract_virgo_description,
        demonImage = Res.drawable.contract_virgo_demon,
        nunImage = Res.drawable.contract_virgo_nun
    ),
    Murcielago(
        choice = Contract.Murcielago,
        title = Res.string.contract_murcielago_title,
        description = Res.string.contract_murcielago_description,
        demonImage = Res.drawable.contract_murcielago_demon,
        nunImage = Res.drawable.contract_murcielago_nun
    ),
    Sirococo(
        choice = Contract.Sirococo,
        title = Res.string.contract_sirococo_title,
        description = Res.string.contract_sirococo_description,
        demonImage = Res.drawable.contract_sirococo_demon,
        nunImage = Res.drawable.contract_sirococo_nun
    ),
    Vivianne(
        choice = Contract.Vivianne,
        title = Res.string.contract_vivianne_title,
        description = Res.string.contract_vivianne_description,
        demonImage = Res.drawable.contract_vivianne_demon,
        nunImage = Res.drawable.contract_vivianne_nun
    );

    val alternatives: List<Alternative> = listOf(Servant(this), Familiar(this))

    interface Alternative {
        val contractOption: ContractOption
        val originalAlternative: Contract.Alternative
        val text: StringResource
    }

    data class Servant(
        override val contractOption: ContractOption,
    ): Alternative {
        override val originalAlternative: Contract.Alternative
            get() = Contract.Servant(contractOption.choice)
        override val text: StringResource
            get() = Res.string.contract_option_servant
    }

    data class Familiar(
        override val contractOption: ContractOption,
    ): Alternative {
        override val originalAlternative: Contract.Alternative
            get() = Contract.Familiar(contractOption.choice)
        override val text: StringResource
            get() = Res.string.contract_option_familiar
    }
}