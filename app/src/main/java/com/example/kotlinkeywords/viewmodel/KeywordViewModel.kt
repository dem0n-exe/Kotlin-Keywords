package com.example.kotlinkeywords.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinkeywords.data.Keyword
import com.example.kotlinkeywords.data.KeywordDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KeywordViewModel(private val keywordDatabase: KeywordDatabase) : ViewModel() {
    suspend fun insert(keyword: Keyword) = withContext(Dispatchers.IO) {
        val keywords = listOf(keyword)
        keywordDatabase.keywordDao().insert(keywords)
    }

    suspend fun getAll(): LiveData<List<Keyword>> = withContext(Dispatchers.IO) {
        keywordDatabase.keywordDao().getAll()
    }
}