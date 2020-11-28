package com.example.projviewbindingpoc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projviewbindingpoc.business.usecase.GetAllAvailableQuestionsUseCase
import com.example.projviewbindingpoc.data.models.Question
import com.example.projviewbindingpoc.data.repository.QuestionRepositoryImpl
import com.example.projviewbindingpoc.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var viewModel: GameViewModel
    private val gameQuestionsAdapter = GameQuestionsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.rvStatements.layoutManager = LinearLayoutManager(this)
        binding.rvStatements.adapter = this.gameQuestionsAdapter

        binding.btCheckResult.setOnClickListener {
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