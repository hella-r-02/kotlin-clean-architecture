package com.example.clean.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.clean.R
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName
import com.example.clean.domain.usecase.GetUserNameUseCase
import com.example.clean.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            context = applicationContext
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)
        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}