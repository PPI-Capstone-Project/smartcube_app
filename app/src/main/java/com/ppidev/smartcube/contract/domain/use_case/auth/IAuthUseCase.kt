package com.ppidev.smartcube.contract.domain.use_case.auth

import com.ppidev.smartcube.common.Resource
import com.ppidev.smartcube.common.ResponseApp
import com.ppidev.smartcube.data.remote.dto.LoginDto
import com.ppidev.smartcube.data.remote.dto.RegisterDto
import kotlinx.coroutines.flow.Flow

interface ILoginUseCase {
    operator fun invoke(email: String, password: String): Flow<Resource<ResponseApp<LoginDto?>>>
}

interface IRegisterUseCase {
    operator fun invoke(username: String, email: String, password: String, confirmPassword: String): Flow<Resource<ResponseApp<RegisterDto?>>>
}

interface IRequestLinkResetPasswordUseCase {
    operator fun invoke(email: String): Flow<Resource<ResponseApp<String?>>>
}

interface IChangePasswordUseCase {
    operator fun invoke(resetToken: String, newPassword: String, newConfirmationPassword: String): Flow<Resource<ResponseApp<Boolean?>>>
}