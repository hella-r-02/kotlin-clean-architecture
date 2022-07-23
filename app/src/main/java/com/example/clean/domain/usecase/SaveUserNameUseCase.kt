package com.example.clean.domain.usecase

import com.example.clean.domain.models.SaveUserNameParam

class SaveUserNameUseCase {
    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }
}