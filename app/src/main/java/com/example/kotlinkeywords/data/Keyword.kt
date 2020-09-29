package com.example.kotlinkeywords.data

data class Keyword(
    val name: String,
    val description: String
)

val keywords: List<Keyword> = List(20) {
    Keyword("if", "conditional statement $it")
}