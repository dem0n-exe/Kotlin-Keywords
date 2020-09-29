package com.example.kotlinkeywords.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinkeywords.data.Keyword
import com.example.kotlinkeywords.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KeywordViewModel(private val repository: Repository) : ViewModel() {

    val keywords: LiveData<List<Keyword>> = repository.getAll()

    fun insert(keyword: Keyword) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(keyword)
    }
}