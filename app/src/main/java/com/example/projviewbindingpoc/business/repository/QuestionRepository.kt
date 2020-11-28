package com.example.projviewbindingpoc.business.repository

import com.example.projviewbindingpoc.data.models.Question

interface QuestionRepository {
    fun getQuestions() : List<Question>
}