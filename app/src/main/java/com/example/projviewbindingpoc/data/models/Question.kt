package com.example.projviewbindingpoc.data.models

data class Question(
    val id: String,
    val statement: String,
    val answerOptions: List<String>,
    val rightAnswerIndex: Int,
    var userChoiceIndex: Int? = null
) {
    fun isTheAnswerRight(): Boolean = userChoiceIndex == rightAnswerIndex
}