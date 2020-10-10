package com.example.kotlinkeywords.utility

import android.content.Context
import com.example.kotlinkeywords.data.KeywordDatabase
import com.example.kotlinkeywords.data.Repository
import com.example.kotlinkeywords.viewmodel.KeywordViewModelFactory

object Injector {
    fun provideKeywordViewModelFactory(context: Context): KeywordViewModelFactory {
        return KeywordViewModelFactory(provideRepository(context))
    }

    private fun provideRepository(context: Context): Repository {
        val database = KeywordDatabase.getInstance(context.applicationContext)
        return Repository(database)
    }
}