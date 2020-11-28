package com.example.projviewbindingpoc.business.usecase

import com.example.projviewbindingpoc.data.models.Question
import com.example.projviewbindingpoc.business.repository.QuestionRepository

class GetAllAvailableQuestionsUseCase(private val questionRepository: QuestionRepository) {
    fun execute() : List<Question> {
        return questionRepository.getQuestions()
    }
}