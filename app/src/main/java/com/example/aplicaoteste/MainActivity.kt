package com.example.aplicaoteste

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clicks = 0

        var bt_incrementa = findViewById<Button>(R.id.bt_incrementa)
        var bt_decrementa = findViewById<Button>(R.id.bt_decrementa)
        var num_incrementa = findViewById<TextView>(R.id.num_incrementa)
        var bt_reset = findViewById<TextView>(R.id.bt_reset)
        var num_modificar = findViewById<TextView>(R.id.num_ultimo_resultado)

        var bt_next = findViewById<TextView>(R.id.bt_next)

        salvarDados()

        bt_incrementa.setOnClickListener {

            clicks++
            num_incrementa.text = clicks.toString()
        }

        bt_decrementa.setOnClickListener {
            if(clicks > 0) {
                clicks--
                num_incrementa.text = clicks.toString()
            }
        }

        bt_reset.setOnClickListener{
            clicks = 0
            num_incrementa.text = clicks.toString()
        }

        bt_next.setOnClickListener {
            val inserirDado: String = clicks.toString()
            num_modificar.text = inserirDado

            val sharedPrefences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPrefences.edit()
            editor.apply(){
                putString("STRING_KEY", inserirDado)
            }.apply()

            val result = Intent(this, Result_of_Increment::class.java)
            result.putExtra("Resultado", clicks.toString())
            startActivity(result)
        }
    }

    private fun salvarDados(){
        var num_modificar = findViewById<TextView>(R.id.num_ultimo_resultado)

        val sharedPrefences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString: String? = sharedPrefences.getString("STRING_KEY", null)

        num_modificar.text = savedString
    }
}