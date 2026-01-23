package com.nsfwcyoamaker.cotdr.domain.engine.model

data class Resources(
    private val values: Map<Currency, Int> = emptyMap()
) {
    constructor(currency: Currency, amount: Int) : this(mapOf(currency to amount))

    operator fun get(currency: Currency): Int = values[currency] ?: 0

    operator fun plus(other: Resources): Resources {
        val merged = values.toMutableMap()
        other.values.forEach { (currency, amount) ->
            merged[currency] = (merged[currency] ?: 0) + amount
        }
        return Resources(merged)
    }

    operator fun times(scalar: Int): Resources {
        return Resources(values.mapValues { it.value * scalar })
    }

    operator fun div(scalar: Int): Resources {
        return Resources(values.mapValues { it.value / scalar })
    }

    companion object {
        val Empty = Resources()
        fun of(vararg pairs: Pair<Currency, Int>) = Resources(pairs.toMap())
    }
}