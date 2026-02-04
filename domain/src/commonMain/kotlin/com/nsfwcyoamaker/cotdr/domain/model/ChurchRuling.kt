package com.nsfwcyoamaker.cotdr.domain.model

enum class ChurchRuling: Ruling {
    SpreadingTheWord {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    TheFaceOfTheChurch {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    TheLimitsOfMatrimony {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    SoftTouchStringFist {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    };
}