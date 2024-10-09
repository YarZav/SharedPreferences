package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var textStorage: TextStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textStorage = TextStorage(this)

        val inputText = binding.inputText
        textStorage.getText {
            inputText.post(Runnable { inputText.setText(it) })
        }

        binding.saveButton.setOnClickListener {
            val text = binding.inputText.text.toString()
            textStorage.setText(text)
        }
    }
}