package com.example.kabaddi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> get() = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> get() = _scoreB

    private val MAX_SCORE = 25

    fun incrementScoreA() {
        _scoreA.value = (_scoreA.value ?: 0) + 1
        checkMaxScore()
    }


    fun incrementScoreB() {
        _scoreB.value = (_scoreB.value ?: 0) + 1
        checkMaxScore()
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
    }

    private fun checkMaxScore() {
        if ((_scoreA.value ?: 0) >= MAX_SCORE || (_scoreB.value ?: 0) >= MAX_SCORE) {
            resetScore() // Reset jika ada tim yang mencapai 25 poin
        }
    }
}
