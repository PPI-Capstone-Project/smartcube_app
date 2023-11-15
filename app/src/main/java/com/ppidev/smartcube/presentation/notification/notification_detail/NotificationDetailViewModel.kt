package com.ppidev.smartcube.presentation.notification.notification_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ppidev.smartcube.common.Resource
import com.ppidev.smartcube.contract.domain.use_case.notification.IViewNotificationUseCase
import com.ppidev.smartcube.domain.model.NotificationModel
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NotificationDetailViewModel @Inject constructor(
    private val viewNotificationUseCase: Lazy<IViewNotificationUseCase>
) : ViewModel() {

    var state by mutableStateOf(NotificationDetailState())
        private set

    fun onEvent(event: NotificationDetailEvent) {
        when (event) {
            is NotificationDetailEvent.GetDetailNotification -> getDetailNotification(event.notificationId)
        }
    }

    private fun getDetailNotification(notificationId: UInt) {
        viewNotificationUseCase.get().invoke(notificationId).onEach {
            when(it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    state = state.copy(
                        notificationModel = it.data?.data ?: NotificationModel(
                            1,
                            "",
                            false,
                            "",
                            "",
                        )
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        error = it.message.toString()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}