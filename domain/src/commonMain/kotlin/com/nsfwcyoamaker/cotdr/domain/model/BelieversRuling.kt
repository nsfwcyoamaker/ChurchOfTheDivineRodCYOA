package com.nsfwcyoamaker.cotdr.domain.model

enum class BelieversRuling: Ruling {
    ActsOfService {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    WhatTheHeartsWants {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    AllForOneAndOneForAll {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    },
    ShadesOfEnthusiasm {
        override val relaxed = Ruling.Relaxed(this)
        override val neutral = Ruling.Neutral(this)
        override val devoted = Ruling.Devoted(this)
    };
}