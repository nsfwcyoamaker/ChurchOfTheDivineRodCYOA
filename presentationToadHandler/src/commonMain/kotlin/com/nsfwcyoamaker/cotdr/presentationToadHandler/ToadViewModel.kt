package com.nsfwcyoamaker.cotdr.presentationToadHandler

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class ToadViewModel<S : ViewState, E : ViewEvent>(
    initialState: S,
    private val scope: CoroutineScope,
) {
    protected abstract val dependencies: ActionDependencies
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state.asStateFlow()
    private val _events = Channel<E>(Channel.BUFFERED)
    val events: Flow<E> = _events.receiveAsFlow()
    protected fun <D : ActionDependencies> dispatch(action: ViewAction<D, S, E>) {
        scope.launch {
            action.execute(dependencies as D, ActionScope(_state, _events))
        }
    }
}