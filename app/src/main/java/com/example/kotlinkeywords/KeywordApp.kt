package com.example.kotlinkeywords

import android.app.Application
import com.example.kotlinkeywords.data.KeywordDatabase

class KeywordApp : Application() {
    private var _databaseInstance: KeywordDatabase? = null
    val databaseInstance: KeywordDatabase
        get() = _databaseInstance!!

    override fun onCreate() {
        super.onCreate()
        _databaseInstance = KeywordDatabase.getInstance(applicationContext)
    }

    override fun onTerminate() {
        super.onTerminate()
        _databaseInstance = null
    }
}