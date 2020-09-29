package com.example.kotlinkeywords.utility

import com.example.kotlinkeywords.KeywordApp
import com.example.kotlinkeywords.data.Repository
import com.example.kotlinkeywords.viewmodel.KeywordViewModelFactory

object Injector {
    fun provideKeywordViewModelFactory(): KeywordViewModelFactory {
        return KeywordViewModelFactory(provideRepository())
    }

    fun provideRepository(): Repository {
        return Repository(KeywordApp().databaseInstance)
    }
}