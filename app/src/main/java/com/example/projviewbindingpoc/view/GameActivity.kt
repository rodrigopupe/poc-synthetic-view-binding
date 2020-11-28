package com.example.projviewbindingpoc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projviewbindingpoc.R
import com.example.projviewbindingpoc.business.usecase.GetAllAvailableQuestionsUseCase
import com.example.projviewbindingpoc.data.models.Question
import com.example.projviewbindingpoc.data.repository.QuestionRepositoryImpl
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel
    private val gameQuestionsAdapter = GameQuestionsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViewModel()
        initViews()
        registerObservers()

        viewModel.getQuestions()
    }

    private fun initViewModel() {
        val useCase = GetAllAvailableQuestionsUseCase(QuestionRepositoryImpl())
        viewModel = ViewModelProvider(this, GameViewModel.Factory(useCase))
            .get(GameViewModel::class.java)
    }

    private fun initViews() {
        rvStatements.layoutManager = LinearLayoutManager(this)
        rvStatements.adapter = this.gameQuestionsAdapter

        btCheckResult.setOnClickListener {
            openResultScreen()
        }
    }

    private fun registerObservers() {
        viewModel.questions.observe(this, questionsObserver)
    }

    private val questionsObserver = Observer<List<Question>> {
        gameQuestionsAdapter.updateList(it)
    }

    private fun openResultScreen() {
        ResultActivity.start(this, viewModel.getRightAnswersCount())
        this.finish()
    }
}