package com.example.projviewbindingpoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projviewbindingpoc.databinding.ActivityMainBinding
import com.example.projviewbindingpoc.view.GameActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerListeners()
    }

    private fun registerListeners() {
        binding.btStartGame.setOnClickListener {
            openNextScreen()
        }
    }

    private fun openNextScreen() {
        val nextScreen = Intent(this, GameActivity::class.java)
        startActivity(nextScreen)
    }
}