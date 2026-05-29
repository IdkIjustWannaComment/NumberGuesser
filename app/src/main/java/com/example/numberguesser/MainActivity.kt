package com.example.numberguesser

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var randomNum = (1..100).random()
        var guessCount  = 0
        val numInput = findViewById<EditText>(R.id.txtNumInput)
        val txtOutput = findViewById<TextView>(R.id.txtOutput)

        var guess = numInput.text.toString().toIntOrNull()

        if (guess != null) {

            if (guess < randomNum) {
                txtOutput.text = "Your guess is less than the number"
            }

            if (guess > randomNum) {
                txtOutput.text = "Your guess is greater than the number"
            }

            if (guess == randomNum) {
                txtOutput.text = "Your guess is equal"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}