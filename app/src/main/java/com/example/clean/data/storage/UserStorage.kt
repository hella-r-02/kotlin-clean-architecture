package com.example.clean.data.storage

import com.example.clean.data.storage.models.User

interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}