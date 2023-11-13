package com.ppidev.smartcube.presentation.verification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ppidev.smartcube.common.Resource
import com.ppidev.smartcube.contract.domain.use_case.auth.IRegisterUseCase
import com.ppidev.smartcube.contract.domain.use_case.auth.IVerificationUseCase
import com.ppidev.smartcube.domain.use_case.auth.VerificationUseCase
import com.ppidev.smartcube.presentation.register.RegisterState
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerificationViewModel @Inject constructor(
    private val verificationUseCase: Lazy<IVerificationUseCase>
) : ViewModel() {
    var state by mutableStateOf(
        VerificationState(
            error = VerificationState.VerificationError()
        )
    )
        private set

    fun onEvent(event: VerificationEvent) {
        when (event) {
            is VerificationEvent.OnVerificationCodeChange -> {
                onVerificationCodeChange(event.code)
            }

            VerificationEvent.HandleVerification -> {
                handleVerification()
            }

            VerificationEvent.HandleCloseDialog -> {
                state = state.copy(isVerificationSuccessful = false)
            }

            else -> {}
        }
    }

    private fun onVerificationCodeChange(code: String) {
        viewModelScope.launch {
            state = state.copy(verificationCode = code)
        }
    }

    private fun handleVerification() {
        verificationUseCase.get().invoke(state.email,state.verificationCode).onEach {
            when (it) {
                is Resource.Success -> {
                    state = state.copy(isVerificationSuccessful = true)
                }

                is Resource.Error -> {
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}
