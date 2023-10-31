package com.ppidev.smartcube.di

import com.ppidev.smartcube.contract.data.repository.IAuthRepository
import com.ppidev.smartcube.contract.data.repository.INotificationRepository
import com.ppidev.smartcube.contract.data.repository.ITokenAppRepository
import com.ppidev.smartcube.data.repository.AuthRepositoryImpl
import com.ppidev.smartcube.data.repository.NotificationRepositoryImpl
import com.ppidev.smartcube.data.repository.TokenAppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNotificationRepository(
        notificationRepository: NotificationRepositoryImpl
    ): INotificationRepository

    @Binds
    @Singleton
    abstract fun bindTokenAppRepository(
        tokenAppRepository: TokenAppRepositoryImpl
    ): ITokenAppRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepository: AuthRepositoryImpl
    ): IAuthRepository
}