package com.oscarg798.remembrall.profile.usecase

import com.oscarg798.remembrall.common.auth.AuthRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend fun execute() {
        authRepository.logout()
    }
}
