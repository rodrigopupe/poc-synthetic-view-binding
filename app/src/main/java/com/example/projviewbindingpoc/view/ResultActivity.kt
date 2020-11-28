package com.example.projviewbindingpoc.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projviewbindingpoc.R
import com.example.projviewbindingpoc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    companion object {
        private const val KEY_RIGHT_ANSWER_COUNT = "RIGHT_ANSWER_COUNT"

        fun start(context: Context, rightAnswerCount: Int) {
            val nextScreen = Intent(context, ResultActivity::class.java)
            nextScreen.putExtra(KEY_RIGHT_ANSWER_COUNT, rightAnswerCount)
            context.startActivity(nextScreen)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val rightAnswerCount = intent.getIntExtra(KEY_RIGHT_ANSWER_COUNT, 0)
        binding.tvMessage.text =
            resources.getQuantityString(R.plurals.rightStatementsCount, rightAnswerCount, rightAnswerCount)
    }
}