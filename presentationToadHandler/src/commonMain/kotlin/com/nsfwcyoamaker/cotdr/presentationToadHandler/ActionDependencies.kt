package com.nsfwcyoamaker.cotdr.presentationToadHandler

import kotlinx.coroutines.CoroutineScope

abstract class ActionDependencies {
    abstract val coroutineScope: CoroutineScope
}