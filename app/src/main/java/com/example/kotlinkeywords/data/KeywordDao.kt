package com.example.kotlinkeywords.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KeywordDao {
    @Query("SELECT * FROM keyword")
    fun getAll(): LiveData<List<Keyword>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(keyword: List<Keyword>)
}