package com.example.projviewbindingpoc.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projviewbindingpoc.business.usecase.GetAllAvailableQuestionsUseCase
import com.example.projviewbindingpoc.data.models.Question

class GameViewModel(private val getAllAvailableQuestionsUseCase: GetAllAvailableQuestionsUseCase) : ViewModel() {

    val questions = MutableLiveData<List<Question>>()

    fun getQuestions() {
        questions.value = getAllAvailableQuestionsUseCase.execute()
    }

    class Factory(val getAllAvailableQuestionsUseCase: GetAllAvailableQuestionsUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return GameViewModel(getAllAvailableQuestionsUseCase) as T
        }
    }
}