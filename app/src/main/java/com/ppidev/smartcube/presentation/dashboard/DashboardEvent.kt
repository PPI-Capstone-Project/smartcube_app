package com.ppidev.smartcube.presentation.dashboard


sealed class DashboardEvent {
    object UnsubscribeToMqttService : DashboardEvent()
    object GetCurrentWeather : DashboardEvent()
    object SetToEmptyServerInfo : DashboardEvent()
    object GetListEdgeServer : DashboardEvent()
    object GetUserProfile : DashboardEvent()
    object StoreFCMToken : DashboardEvent()
    data class GetServerInfoMqtt(val topic: String) : DashboardEvent()
    data class GetDevicesConfig(val serverId: UInt) : DashboardEvent()
    data class GetProcessDeviceId(val topic: String) : DashboardEvent()
    data class SetEdgeServerId(val id: UInt) : DashboardEvent()
    data class SubscribeTopicMqtt(val topic: String) : DashboardEvent()
}
