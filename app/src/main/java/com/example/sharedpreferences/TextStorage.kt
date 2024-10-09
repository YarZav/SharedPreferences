package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import kotlin.concurrent.thread

class TextStorage(context: Context) {
    private val sharedPreferences: SharedPreferences
    private val key = "Key"

    init {
        this.sharedPreferences = context.getSharedPreferences("name", 0)
    }

    fun getText(completion: (String?) -> Boolean) {
        thread(start = true) {
            val text = sharedPreferences.getString(key, null)
            completion(text)
        }
    }

    fun setText(text: String?) {
        thread(start = true) {
            with(sharedPreferences.edit()) {
                putString(key, text)
                apply()
            }
        }
    }
}