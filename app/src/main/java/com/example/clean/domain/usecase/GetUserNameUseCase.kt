package com.example.clean.domain.usecase

import com.example.clean.domain.models.UserName
import com.example.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}