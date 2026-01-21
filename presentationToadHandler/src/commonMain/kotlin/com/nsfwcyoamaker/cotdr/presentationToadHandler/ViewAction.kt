package com.nsfwcyoamaker.cotdr.presentationToadHandler

interface ViewAction<D : ActionDependencies, S : ViewState, E : ViewEvent> {
    suspend fun execute(dependencies: D, scope: ActionScope<S, E>)
}
