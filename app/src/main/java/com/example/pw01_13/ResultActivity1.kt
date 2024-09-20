package com.example.pw01_13

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val res: TextView = findViewById(R.id.showResult)



        val H_c = intent.getFloatExtra("H_c", 0.0F).toString()
        val C_c = intent.getFloatExtra("C_c", 0.0F).toString()
        val S_c = intent.getFloatExtra("S_c", 0.0F).toString()
        val N_c = intent.getFloatExtra("N_c", 0.0F).toString()
        val O_c = intent.getFloatExtra("O_c", 0.0F).toString()
        val A_c = intent.getFloatExtra("A_c", 0.0F).toString()

        res.setText("H_c: " + H_c + "\nC_c: " + C_c + "\nS_c: " + S_c + "\nN_c: "
                + N_c + "\nO_c: " + O_c +  "\nA_c: " + A_c)
    }

    fun onClickMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}