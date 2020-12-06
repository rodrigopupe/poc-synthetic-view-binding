package com.example.projviewbindingpoc.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.projviewbindingpoc.R
import com.example.projviewbindingpoc.data.models.GameResult
import com.example.projviewbindingpoc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    companion object {
        private const val KEY_GAME_RESULT = "GAME_RESULT"

        fun start(context: Context, gameResult: GameResult) {
            val nextScreen = Intent(context, ResultActivity::class.java)
            nextScreen.putExtra(KEY_GAME_RESULT, gameResult)
            context.startActivity(nextScreen)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)

        initViews()
    }

    private fun initViews() {
        val gameResult = intent.getParcelableExtra<GameResult>(KEY_GAME_RESULT)!!
        binding.gameResult = gameResult
    }
}