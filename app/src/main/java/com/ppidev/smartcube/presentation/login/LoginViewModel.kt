package com.ppidev.smartcube.presentation.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ppidev.smartcube.common.Resource
import com.ppidev.smartcube.contract.domain.use_case.auth.ILoginUseCase
import com.ppidev.smartcube.utils.validateEmail
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: Lazy<ILoginUseCase>
) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.HandleLogin -> {
                handleLogin(
                    callbackOnSuccess = event.callback
                )
            }

            LoginEvent.ToggleShowPassword -> {
                state = state.copy(
                    isShowPassword = !state.isShowPassword
                )
            }

            is LoginEvent.OnEmailChange -> {
                val str = event.str
                onEmailChange(str)
            }

            is LoginEvent.OnPasswordChange -> {
                val str = event.str
                onPasswordChange(str)
            }

            is LoginEvent.ToRegisterScreen -> {
                event.callback()
            }

            is LoginEvent.ToResetPasswordScreen -> {
                event.callback()
            }
        }
    }

    private fun handleLogin(callbackOnSuccess: () -> Unit) {

        if (state.email.isEmpty()) {
            state = state.copy(
                error = LoginState.LoginError(
                    email = "Email cannot be empty"
                )
            )

            return
        }

        if (state.password.isEmpty()) {
            state = state.copy(
                error = LoginState.LoginError(
                    password = "Password cannot be empty"
                )
            )

            return
        }

        loginUseCase.get().invoke(state.email, state.password).onEach {
            when (it) {
                is Resource.Loading -> {
                    setIsLoading(true)
                }

                is Resource.Success -> {
                    setIsLoading(false)
                    state = state.copy(
                        error = LoginState.LoginError(
                            message = ""
                        )
                    )
                    callbackOnSuccess()
                }

                is Resource.Error -> {
                    setIsLoading(false)
                    state = state.copy(
                        error = LoginState.LoginError(
                            message = it.message ?: ""
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun onEmailChange(str: String) {
        state = if (!validateEmail(str)) {
            state.copy(
                error = LoginState.LoginError(
                    email = "Email is Not Valid",
                )
            )
        } else {
            state.copy(
                error = LoginState.LoginError(
                    email = "",
                )
            )
        }

        state = state.copy(
            email = str
        )
    }

    private fun onPasswordChange(str: String) {
        viewModelScope.launch {
            if (state.password.isNotEmpty()) {
                state = state.copy(
                    error = LoginState.LoginError(
                        password = ""
                    )
                )
            }

            state = state.copy(
                password = str
            )
        }
    }

    private fun setIsLoading(status: Boolean) {
        viewModelScope.launch {
            state = state.copy(
                isLoginLoading = status
            )
        }
    }
}