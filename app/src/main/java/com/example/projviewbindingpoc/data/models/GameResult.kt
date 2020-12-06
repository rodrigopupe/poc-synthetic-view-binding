package com.example.projviewbindingpoc.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameResult (
    val questions: List<Question>
): Parcelable {
    fun getTotalRightAnswers(): Int {
        return questions.count { it.isTheAnswerRight() }
    }
}