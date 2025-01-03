package com.sgeorgiev24.productbrowser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<ScreenState : Any, Action, Event>(
    initialState: ScreenState
) : ViewModel() {

    @PublishedApi
    internal val mState: MutableStateFlow<ScreenState> = MutableStateFlow(initialState)
    val state: StateFlow<ScreenState> = mState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = initialState
    )

    private val actions = MutableSharedFlow<Action>()

    private val _events = Channel<Event>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        collectActions()
    }

    open suspend fun handleActions(action: Action) {
        // To or not to override, some screens mights not have actions
    }

    private fun collectActions() = viewModelScope.launch {
        actions.collect { handleActions(it) }
    }

    val submitAction: (action: Action) -> Unit = {
        viewModelScope.launch { actions.emit(it) }
    }

    val submitEvent: (event: Event) -> Unit = {
        viewModelScope.launch { _events.send(it) }
    }
}
