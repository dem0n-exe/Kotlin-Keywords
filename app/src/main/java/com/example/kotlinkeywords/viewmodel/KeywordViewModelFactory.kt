package com.example.kotlinkeywords.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinkeywords.data.Repository

@Suppress("UNCHECKED_CAST")
class KeywordViewModelFactory(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(p0: Class<T>): T {
        return KeywordViewModel(repository) as T
    }
}