package com.natiqhaciyef.kotlinandroidknowledges.android.compose

//class MVIDelegate<UiState, UiAction, SideEffect> internal constructor(
//    initialUiState: UiState,
//) : MVI<UiState, UiAction, SideEffect> {
//
//    private val _uiState = MutableStateFlow(initialUiState)
//    override val uiState: StateFlow<UiState> = _uiState.asStateFlow()
//
//    private val _sideEffect by lazy { Channel<SideEffect>() }
//    override val sideEffect: Flow<SideEffect> by lazy { _sideEffect.receiveAsFlow() }
//
//    override fun onAction(uiAction: UiAction) {}
//
//    override fun updateUiState(newUiState: UiState) {
//        _uiState.update { newUiState }
//    }
//
//    override fun updateUiState(block: UiState.() -> UiState) {
//        _uiState.update(block)
//    }
//
//    override fun CoroutineScope.emitSideEffect(effect: SideEffect) {
//        this.launch { _sideEffect.send(effect) }
//    }
//}
//
//fun <UiState, UiAction, SideEffect> mvi(
//    initialUiState: UiState,
//): MVI<UiState, UiAction, SideEffect> = MVIDelegate(initialUiState)
//
//interface MVI<UiState, UiAction, SideEffect> {
//    val uiState: StateFlow<UiState>
//    val sideEffect: Flow<SideEffect>
//
//    fun onAction(uiAction: UiAction)
//
//    fun updateUiState(block: UiState.() -> UiState)
//
//    fun updateUiState(newUiState: UiState)
//
//    // Another option would to add the extention on ViewModel
//    // ViewModel.emitSideEffect(effect: SideEffect)
//    // to make it easier to use if you're only using it in ViewModel
//    //
//    // or just leave this responsibility to the MVIDelegate to
//    // get a CoroutineScope. see: https://proandroiddev.com/lighten-mvi-architecture-delegate-responsibilities-to-new-components-7ea27ea54021
//    // fun emitSideEffect(effect: SideEffect)
//    fun CoroutineScope.emitSideEffect(effect: SideEffect)
//}