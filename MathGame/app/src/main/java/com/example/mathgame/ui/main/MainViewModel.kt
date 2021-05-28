package com.example.mathgame.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _leftNumber = MutableLiveData<Int>()
    val leftNumber: LiveData<Int> = _leftNumber

    private val _rightNumber = MutableLiveData<Int>()
    val rightNumber: LiveData<Int> = _rightNumber

    private val _rightAnswer = MutableLiveData<Int>()
    val rightAnswer: LiveData<Int> = _rightAnswer

    private val _leftAnswer = MutableLiveData<Int>()
    val leftAnswer: LiveData<Int> = _leftAnswer

    private val _middleAnswer = MutableLiveData<Int>()
    val middleAnswer: LiveData<Int> = _middleAnswer

    fun setNewNumbers(){
        _leftNumber.value = (0..9).random()
        _rightNumber.value = (0..9).random()
    }

    fun setButtons(){
        val product1 = _leftNumber.value
        val product2 = _rightNumber.value
        val answer = product2?.let { product1?.times(it) }
        val list = listOf(answer, answer?.minus(1), answer?.plus(1))
        list.shuffled()
        _leftAnswer.value = list[0]
        _rightAnswer.value = list[1]
        _middleAnswer.value = list[2]

    }

}