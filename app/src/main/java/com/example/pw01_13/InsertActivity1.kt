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

class InsertActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_insert1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valH_p: EditText = findViewById(R.id.valHp)
        val valC_p: EditText = findViewById(R.id.valC)
        val valS_p: EditText = findViewById(R.id.valSp)
        val valN_p: EditText = findViewById(R.id.valNp)
        val valO_p: EditText = findViewById(R.id.valOp)
        val valW: EditText = findViewById(R.id.valW)
        val valA_p: EditText = findViewById(R.id.valAp)

        val calcButton: Button = findViewById(R.id.calcButton)

        calcButton.setOnClickListener{

            // внесеня даних
            val H_p = valH_p.text.toString().toFloat()
            val C_p = valC_p.text.toString().toFloat()
            val S_p = valS_p.text.toString().toFloat()
            val N_p = valN_p.text.toString().toFloat()
            val O_p = valO_p.text.toString().toFloat()
            val W = valW.text.toString().toFloat()
            val A_p = valA_p.text.toString().toFloat()

            //розрахунок сухого коефіцієнта
            val dry = dry_coef(W)

            //елементи сухої суміщі
            val H_c = H_p*dry
            val C_c = C_p*dry
            val S_c = S_p*dry
            val N_c = N_p*dry
            val O_c = O_p*dry
            val A_c = A_p*dry

            // розрахунток горючого коефіцієнта
            val comb = comb_coef(W, A_p)

            //елементи горючої суміщі
            val H_comb = H_p*comb
            val C_comb = C_p*comb
            val S_comb = S_p*comb
            val N_comb = N_p*comb
            val O_comb = O_p*comb

            val Q_low = q_basic(C_p, H_p, O_p, S_p, W)/1000 // нижча теплота згорання у мДж
            val Q_dry = q_dry(Q_low, W)  //нижча теплота згорання для сухої маси у мДж
            val Q_comb = q_comb(Q_low, W, A_p) //нижча теплота згорання для горючої маси у мДж
            // перехід до активності із виведенням результатів
            val intent = Intent(this, ResultActivity1::class.java)

            intent.putExtra("H_c", H_c)
            intent.putExtra("C_c", C_c)
            intent.putExtra("S_c", S_c)
            intent.putExtra("N_c", N_c)
            intent.putExtra("O_c", O_c)
            intent.putExtra("A_c", A_c)

            intent.putExtra("H_comb", H_comb)
            intent.putExtra("C_comb", C_comb)
            intent.putExtra("S_comb", S_comb)
            intent.putExtra("N_comb", N_comb)
            intent.putExtra("O_comb", O_comb)

            intent.putExtra("Q_low", Q_low)
            intent.putExtra("Q_dry", Q_dry)
            intent.putExtra("Q_comb", Q_comb)

            startActivity(intent)

        }
    }

    fun dry_coef(water: Float): Float {
        val coef = 100/(100-water)
        return coef
    }

    fun comb_coef(water: Float, ash: Float): Float {
        val coef = 100/(100-water-ash)
        return coef
    }

    fun q_basic(c: Float, h: Float, o: Float, s:Float, w:Float): Double {
        val q = 339*c + 1030*h - 108.8*(o - s) - 25*w
        return q
    }

    fun q_dry(q_work: Double, w: Float): Double{
        val q = (q_work + 0.025*w)*(100/(100-w))
        return q
    }

    fun q_comb(q_work: Double, w: Float, a: Float): Double{
        val q = (q_work + 0.025*w)*(100/(100-w-a))
        return q
    }


    fun onClickMain(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}