package com.example.kotlinkeywords.utility

import com.example.kotlinkeywords.KeywordApp
import com.example.kotlinkeywords.viewmodel.KeywordViewModelFactory

object Injector {
    fun provideKeywordViewModelFactory(): KeywordViewModelFactory {
        val database = KeywordApp().databaseInstance
        return KeywordViewModelFactory(database)
    }
}