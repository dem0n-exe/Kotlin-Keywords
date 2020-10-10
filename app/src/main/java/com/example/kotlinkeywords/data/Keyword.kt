package com.example.kotlinkeywords.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Keyword(
    @PrimaryKey val name: String,
    val description: String
)

val dummyKeywords: List<Keyword> = List(20) {
    Keyword("if$it", "conditional statement $it")
}