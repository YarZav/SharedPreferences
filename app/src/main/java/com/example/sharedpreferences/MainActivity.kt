package com.example.sharedpreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val textKey = "TextValue"

        val sharedPreferencesText = sharedPreferences.getString(textKey, "")
        binding.inputText.setText(sharedPreferencesText)

        binding.saveButton.setOnClickListener {
            val inputText = binding.inputText.text.toString()
            with(sharedPreferences.edit()) {
                putString(textKey, inputText)
                apply()
            }
        }
    }
}