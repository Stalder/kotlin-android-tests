package com.example.kotlincrud

import android.content.SharedPreferences

class HistoryStorage {

    private lateinit var sharedPreferences: SharedPreferences
    private var history: List<HistoryOperation> = ArrayList()

    companion object {
        val instance = HistoryStorage()
    }

    fun init(prefs: SharedPreferences) {
        sharedPreferences = prefs
    }

    fun getHistory() {
        //
    }

    fun addOperationToHistory() {
        //
    }


}