package com.example.kotlinkeywords.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Keyword(
    @PrimaryKey val name: String,
    val description: String
)

val dummyKeywords: List<Keyword> = listOf(
    Keyword(name = "as", description = "is used for type casts or specifies an alias for import"),
    Keyword(name = "break", description = "terminates the execution of a loop"),
    Keyword(name = "class", description = "declares a class"),
    Keyword(
        name = "continue",
        description = "proceeds to the next step of the nearest enclosing loop"
    ),
    Keyword(name = "do", description = "begins a do/while loop"),
    Keyword(
        name = "else",
        description = "defines the branch of an if expression which is executed when the condition is false"
    ),
    Keyword(name = "false", description = "specifies the 'false' value of the Boolean type"),
    Keyword(name = "for", description = "begins a for loop"),
    Keyword(name = "fun", description = "declares a function"),
    Keyword(name = "if", description = "begins an if expression"),
    Keyword(name = "in", description = "specifies the object being iterated in a for loop"),
    Keyword(name = "interface", description = "declares an interface"),
    Keyword(name = "is", description = "checks that a value has a certain type"),
    Keyword(
        name = "null",
        description = "is a constant representing an object reference that doesn't point to any object"
    ),
    Keyword(name = "object", description = "declares a class and its instance at the same time"),
    Keyword(name = "package", description = "specifies the package for the current file"),
    Keyword(
        name = "return",
        description = "returns from the nearest enclosing function or anonymous function"
    ),
    Keyword(
        name = "super",
        description = "refers to the superclass implementation of a method or property"
    ),
    Keyword(name = "this", description = "refers to the current receiver"),
    Keyword(name = "throw", description = "throws an exception")
)