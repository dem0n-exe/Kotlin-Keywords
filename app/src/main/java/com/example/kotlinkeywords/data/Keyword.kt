package com.example.kotlinkeywords.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Keyword(
    @PrimaryKey val name: String,
    @ColumnInfo(defaultValue = "No description") val description: String
)

val dummyKeywords: List<Keyword> = List(20) {
    Keyword("if", "conditional statement $it")
}