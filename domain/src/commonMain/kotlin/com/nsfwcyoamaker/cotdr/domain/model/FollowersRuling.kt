package com.nsfwcyoamaker.cotdr.domain.model

enum class FollowersRuling: Ruling {
    ShapeOfSex {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    ThePathLessWalked {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    TheFemininePenis {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    TheFirstOfMany {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    };
}