package com.example.pw01_13

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InsertActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_insert2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val C_m: EditText = findViewById(R.id.inputC)
        val H_m: EditText = findViewById(R.id.inputH)
        val O_m: EditText = findViewById(R.id.inputO)
        val S_m: EditText = findViewById(R.id.inputS)
        val Q_min_m: EditText = findViewById(R.id.inputQ)
        val W_m: EditText = findViewById(R.id.inputW)
        val A_m: EditText = findViewById(R.id.inputA)
        val V_m: EditText = findViewById(R.id.inputV)

        val calcButton2: Button = findViewById(R.id.calcButton2)

        calcButton2.setOnClickListener {

            val C = C_m.text.toString().toFloat()
            val H = H_m.text.toString().toFloat()
            val O = O_m.text.toString().toFloat()
            val S = S_m.text.toString().toFloat()
            val Q = Q_min_m.text.toString().toFloat()
            val W = W_m.text.toString().toFloat()
            val A = A_m.text.toString().toFloat()
            val V = V_m.text.toString().toFloat()

            val C_w = C*((100 - W - A)/100)
            val H_w = H*((100 - W - A)/100)
            val O_w = O*((100 - W - A)/100)
            val S_w = S*((100 - W - A)/100)
            val A_w = A*((100 - W)/100)
            val V_w = V*((100 - W)/100)

            val Q_w = Q*((100- W - A_w)/100) - 0.025*W

            val intent = Intent(this, ResultActivity2::class.java)
            intent.putExtra("C_w", C_w)
            intent.putExtra("H_w", H_w)
            intent.putExtra("O_w", O_w)
            intent.putExtra("S_w", S_w)
            intent.putExtra("A_w", A_w)
            intent.putExtra("V_w", V_w)
            intent.putExtra("Q_w", Q_w)
            startActivity(intent)

        }
    }

    fun onClickMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}