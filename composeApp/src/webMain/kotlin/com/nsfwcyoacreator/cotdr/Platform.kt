package com.nsfwcyoacreator.cotdr

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform