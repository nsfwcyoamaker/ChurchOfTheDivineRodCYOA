package com.nsfwcyoamaker.cotdr.domain.model

import com.nsfwcyoamaker.cotdr.domain.engine.model.Resources
import com.nsfwcyoamaker.cotdr.domain.engine.model.SimpleChoice

enum class Priestess: SimpleChoice {
    Acerola,
    Celeste,
    Desuri,
    Erina,
    Helena;

    override val cost: Resources get() = Resources.Empty
}