package com.example.projviewbindingpoc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val id: String,
    val statement: String,
    val answerOptions: List<String>,
    val rightAnswerIndex: Int,
    var userChoiceIndex: Int? = null
) : Parcelable {
    fun isTheAnswerRight(): Boolean = userChoiceIndex == rightAnswerIndex
}