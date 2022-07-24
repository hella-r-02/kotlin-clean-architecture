package com.example.clean.dl

import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.UserStorage
import com.example.clean.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.clean.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}