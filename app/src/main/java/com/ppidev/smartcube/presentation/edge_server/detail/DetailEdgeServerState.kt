package com.ppidev.smartcube.presentation.edge_server.detail

import com.ppidev.smartcube.data.remote.dto.DeviceConfigDto
import com.ppidev.smartcube.data.remote.dto.DeviceStatusDto
import com.ppidev.smartcube.data.remote.dto.EdgeDevicesInfoDto

data class DetailEdgeServerState(
    val isLoading: Boolean = false,
    val edgeDevicesInfo: EdgeDevicesInfoDto? = null,
    val serverInfo: DeviceStatusDto? = null,
    val devices: List<DeviceConfigDto> = emptyList()
)