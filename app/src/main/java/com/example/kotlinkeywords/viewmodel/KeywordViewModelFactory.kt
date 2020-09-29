package com.example.kotlinkeywords.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinkeywords.data.KeywordDatabase

@Suppress("UNCHECKED_CAST")
class KeywordViewModelFactory(private val keywordDatabase: KeywordDatabase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(p0: Class<T>): T {
        return KeywordViewModel(keywordDatabase) as T
    }
}