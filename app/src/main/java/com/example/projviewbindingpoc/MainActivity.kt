package com.example.projviewbindingpoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projviewbindingpoc.R
import com.example.projviewbindingpoc.view.GameActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerListeners()
    }

    private fun registerListeners() {
        btStartGame.setOnClickListener {
            openNextScreen()
        }
    }

    private fun openNextScreen() {
        val nextScreen = Intent(this, GameActivity::class.java)
        startActivity(nextScreen)
    }
}