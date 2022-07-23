package com.example.clean.data.repository

import android.content.Context
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName
import com.example.clean.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl(context: Context) : UserRepository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val secondName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = secondName)
    }
}