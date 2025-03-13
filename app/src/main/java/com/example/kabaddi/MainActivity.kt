package com.example.kabaddi

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.kabaddi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Mengamati perubahan skor dengan LiveData
        scoreViewModel.scoreA.observe(this) { newScoreA ->
            binding.skorA.text = newScoreA.toString()
        }

        scoreViewModel.scoreB.observe(this) { newScoreB ->
            binding.skorB.text = newScoreB.toString()
        }

        // Event Listener untuk tombol Team A
        binding.tambah1a.setOnClickListener {
            scoreViewModel.incrementScoreA()
        }

        binding.tambah2a.setOnClickListener {
            repeat(2) { scoreViewModel.incrementScoreA() }
        }

        // Event Listener untuk tombol Team B
        binding.tambah1b.setOnClickListener {
            scoreViewModel.incrementScoreB()
        }

        binding.tambah2b.setOnClickListener {
            repeat(2) { scoreViewModel.incrementScoreB() }
        }

        // Tombol Reset
        binding.btnreset.setOnClickListener {
            scoreViewModel.resetScore()
        }

        // Mengatur padding sesuai dengan insets sistem (opsional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
