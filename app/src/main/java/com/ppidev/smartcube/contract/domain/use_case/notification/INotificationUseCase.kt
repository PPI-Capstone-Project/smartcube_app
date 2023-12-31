package com.ppidev.smartcube.contract.domain.use_case.notification

import com.ppidev.smartcube.common.Resource
import com.ppidev.smartcube.common.ResponseApp
import com.ppidev.smartcube.domain.model.NotificationModel
import kotlinx.coroutines.flow.Flow

interface IListNotificationUseCase {
    operator fun invoke(): Flow<Resource<List<NotificationModel>>>
}

interface IViewNotificationUseCase {
    operator fun invoke(notificationId: UInt, edgeServerId: UInt): Flow<Resource<ResponseApp<NotificationModel?>>>
}