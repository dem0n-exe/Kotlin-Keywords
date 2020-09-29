package com.example.kotlinkeywords.data

data class Keyword(
    val id: Int,
    val name: String,
    val description: String
)

val keywords: List<Keyword> = List(20) {
    Keyword(1, "if", "conditional statement $it")
}