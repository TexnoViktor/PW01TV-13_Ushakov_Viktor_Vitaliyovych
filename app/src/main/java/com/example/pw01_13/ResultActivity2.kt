package com.example.pw01_13

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val res: TextView = findViewById(R.id.showResult2)

        val C_w = intent.getFloatExtra("C_w", 0.0F).toString()
        val H_w = intent.getFloatExtra("H_w", 0.0F).toString()
        val O_w = intent.getFloatExtra("O_w", 0.0F).toString()
        val S_w = intent.getFloatExtra("S_w", 0.0F).toString()
        val A_w = intent.getFloatExtra("A_w", 0.0F).toString()
        val V_w = intent.getFloatExtra("V_w", 0.0F).toString()
        val Q_w = intent.getDoubleExtra("Q_w", 0.0).toString()

        val res_elements = "Склад робочої маси мазуту становитиме:\nHР= " + H_w +
                "\nCР= " + C_w + "\nSP= " + S_w + "\nOP= " + O_w + "\nVP= " + V_w + "\nAP= " + A_w + "\n"

        val res_q = "Нижча теплота згоряння мазуту на робочу масу для робочої маси за заданим " +
                "складом компонентів палива становить: " + Q_w + "МДж/кг."

        res.setText(res_elements + res_q)

    }

    fun onClickMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}