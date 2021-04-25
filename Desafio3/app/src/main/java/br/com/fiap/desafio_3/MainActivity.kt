package br.com.fiap.desafio_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            if (validarCampo()) {
                // nao vai ser alterado o valor da variavel
                val altura = txtAltura.text.toString().toDouble()
                // pode ser que o valor seja alterado
                var pesoIdeal : Double

                if (rbMasc.isChecked) {
                    pesoIdeal = (72.7 * altura) - 58
                }else {
                    pesoIdeal = (62.1 * altura) - 44.7
                }
                val dec = DecimalFormat("#.0")
                var alert = "Seu peso ideal é ${dec.format(pesoIdeal)} kg"
                Toast.makeText(this, alert, Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun validarCampo(): Boolean {

        if (txtAltura.text.trim().isEmpty()) {
           var msg = "Informe sua altura primeiro"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}