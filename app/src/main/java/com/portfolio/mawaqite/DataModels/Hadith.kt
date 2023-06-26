package com.portfolio.mawaqite.DataModels

data class Hadith(
    val id: String,
    val title: String,
    val hadeeth: String,
    val attribution: String,
    val grade: String,
    val explanation: String,
    val hints: List<String>,
    val categories: List<String>,
    val translations: List<String>,
    val words_meanings: List<WordMeaning>,
    val reference: String
)

data class WordMeaning(
    val word: String,
    val meaning: String
)
