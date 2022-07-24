package com.example.clean.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clean.R

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")
        vm = ViewModelProvider(
            this,
            MainViewModelFactory(this)
        ).get(MainViewModel::class.java) //чтобы ViewModel не пересоздавалось

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(
            this,
            Observer { //как только переменная меняется, вызывается этот кусок кода
                dataTextView.text = it
            })

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }
        receiveButton.setOnClickListener {
            vm.load()
        }
    }
}