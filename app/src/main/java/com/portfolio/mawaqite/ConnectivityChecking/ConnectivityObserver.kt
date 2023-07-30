package com.portfolio.mawaqite.ConnectivityChecking

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observer(): Flow<Status>
    enum class Status{
        connected,notConnected
    }
}