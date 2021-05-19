package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    // Declares top-level variable in class for binding object
    // lateinit keyword initializes variable before use
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // initializes binding object, used to access Views in xml
        setContentView(binding.root) // specifies root of hierarchy of views in app
        binding.calculateButton.setOnClickListener{ calculateTip()}
    }

    private fun calculateTip()
    {
        val stringOfCost = binding.costOfService.text.toString()
        val serviceCost = stringOfCost.toDoubleOrNull()
        if (serviceCost == null) {
            binding.tipResult.text = ""
            return
        }
        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId)
        {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = serviceCost * tipPercentage
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp)
        {
            tip = ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}


/*
// Old way with findViewById()
val myButton: Button = findViewById(R.id.my_button)
myButton.text = "A button"

// Better way with view binding
val myButton: Button = binding.myButton
myButton.text = "A button"

// Best way with view binding and no extra variable
binding.myButton.text = "A button"
*/