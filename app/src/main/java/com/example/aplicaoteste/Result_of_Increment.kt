package com.example.aplicaoteste

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result_of_Increment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_of_increment)

        var num_resultado = findViewById<TextView>(R.id.num_resultado)

        var num: String? = getIntent().getStringExtra("Resultado")
        num_resultado.setText(num)

    }
}