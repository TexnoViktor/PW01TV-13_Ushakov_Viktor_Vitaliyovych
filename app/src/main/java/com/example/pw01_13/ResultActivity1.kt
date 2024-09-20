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

        val res_c = "Склад сухої маси палива становитиме:\nH_c: " + H_c +
                "\nC_c: " + C_c + "\nS_c: " + S_c + "\nN_c: " + N_c + "\nO_c: " + O_c +  "\nA_c: " + A_c + "\n\n"

        val H_comb = intent.getFloatExtra("H_comb", 0.0F).toString()
        val C_comb = intent.getFloatExtra("C_comb", 0.0F).toString()
        val S_comb = intent.getFloatExtra("S_comb", 0.0F).toString()
        val N_comb = intent.getFloatExtra("N_comb", 0.0F).toString()
        val O_comb = intent.getFloatExtra("O_comb", 0.0F).toString()

        val res_comb = "Склад горючої маси палива становитиме:\nH_г: " + H_comb +
                "\nC_г: " + C_comb + "\nS_г: " + S_comb + "\nN_г: " + N_comb + "\nO_г: " + O_comb +  "\n\n"

        val Q_low = intent.getDoubleExtra("Q_low", 0.0).toString()

        val res_Q_low = "Нижча теплота згоряння для робочої маси за" +
                " заданим складом компонентів палива становить: " + Q_low + "МДж/кг\n\n"

        val Q_dry = intent.getDoubleExtra("Q_dry", 0.0).toString()

        val res_Q_dry = "Нижча теплота згоряння для сухої маси за" +
                " заданим складом компонентів палива становить: " + Q_dry + "МДж/кг\n\n"

        val Q_comb = intent.getDoubleExtra("Q_comb", 0.0).toString()

        val res_Q_comb = "Нижча теплота згоряння для горючої маси за" +
                " заданим складом компонентів палива становить: " + Q_comb + "МДж/кг\n\n"

        res.setText(res_c + res_comb + res_Q_low + res_Q_dry + res_Q_comb)
    }

    fun onClickMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}