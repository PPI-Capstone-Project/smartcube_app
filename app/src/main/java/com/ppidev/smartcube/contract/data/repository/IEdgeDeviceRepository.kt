package com.ppidev.smartcube.contract.data.repository

import com.ppidev.smartcube.common.ResponseApp
import com.ppidev.smartcube.data.remote.dto.CreateEdgeDeviceDto
import com.ppidev.smartcube.data.remote.dto.EdgeDevicesInfoDto

interface IEdgeDeviceRepository {
    suspend fun getEdgeDevicesInfo(edgeServerId: UInt): ResponseApp<EdgeDevicesInfoDto?>

    suspend fun addEdgeDevices(
        edgeServerId: UInt,
        vendorName: String,
        vendorNumber: String,
        type: String,
        sourceType: String,
        devSourceId: String,
        rtspSourceAddress: String,
        assignedModelType: UInt,
        assignedModelIndex: UInt,
        additionalInfo: String
    ): ResponseApp<CreateEdgeDeviceDto?>
}