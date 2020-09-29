package com.example.kotlinkeywords.data

import androidx.lifecycle.LiveData

class Repository(private val keywordDatabase: KeywordDatabase) {

    fun getAll(): LiveData<List<Keyword>> = keywordDatabase.keywordDao().getAll()

    suspend fun insert(keyword: Keyword) {
        val keywords = listOf(keyword)
        keywordDatabase.keywordDao().insert(keywords)
    }
}