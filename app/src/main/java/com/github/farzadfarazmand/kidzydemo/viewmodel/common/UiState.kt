package com.github.farzadfarazmand.kidzydemo.viewmodel.common

sealed class UiState

object Loading : UiState()
object Success : UiState()
object NetworkError : UiState()
object EmptyList : UiState()
class Error(val error: Throwable) : UiState()