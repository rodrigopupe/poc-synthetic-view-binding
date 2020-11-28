package com.example.projviewbindingpoc.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projviewbindingpoc.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_result)

        initViews()
    }

    private fun initViews() {
        val rightAnswerCount = intent.getIntExtra(KEY_RIGHT_ANSWER_COUNT, 0)
        tvResultMessage.text = resources.getQuantityString(R.plurals.rightStatementsCount, rightAnswerCount, rightAnswerCount)
    }
}