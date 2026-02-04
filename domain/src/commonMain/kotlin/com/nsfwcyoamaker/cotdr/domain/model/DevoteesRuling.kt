package com.nsfwcyoamaker.cotdr.domain.model

enum class DevoteesRuling: Ruling {
    TheMortalRod {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    PracticeMakesPerfect {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    FellowshipAndFondness {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    AspirationOfDevotion {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    };
}