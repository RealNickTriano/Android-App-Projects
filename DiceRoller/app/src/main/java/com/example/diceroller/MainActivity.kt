package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(findViewById(R.id.textView))
            rollDice(findViewById(R.id.textView2))
        }
    }

    private fun rollDice(textId: TextView) {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = textId
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
// comment

/**
        comments
 */
