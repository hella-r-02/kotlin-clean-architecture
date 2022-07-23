package com.example.clean.domain.usecase

import com.example.clean.domain.models.UserName

class GetUserNameUseCase {
    fun execute(): UserName {
        return UserName(firstName = "Kiparo", lastName = "Hello")
    }
}