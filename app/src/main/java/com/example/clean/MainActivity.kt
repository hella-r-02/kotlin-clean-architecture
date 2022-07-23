package com.example.clean

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataTextView = findViewById<TextView>(R.id.dataTextView)
        var dataEditView = findViewById<EditText>(R.id.dataEditText)
        var sendButton = findViewById<Button>(R.id.sendButton)
        var receiveButton = findViewById<Button>(R.id.receiveButton)
        sendButton.setOnClickListener {

        }
        receiveButton.setOnClickListener {

        }
    }
}