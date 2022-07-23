package com.example.clean.domain.repository

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}