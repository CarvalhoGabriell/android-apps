package br.com.fiap.checkpoint_2tdst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculadora.*


/*
GABRIEL CARVALHO FERNANDES
THALITA FEITOSA DA SILVA
MATEUS RAMOS MARTINS
 */

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        op.text = intent.getStringExtra("msg")

        calcular.setOnClickListener{view: View?->
            if(validarCampos()){
                var total = calcular()
                Toast.makeText(this, "Resultado do calculo: ${total}", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Por favor preencha todos os campos.", Toast.LENGTH_SHORT ).show()
            }

        }
    }


    fun validarCampos(): Boolean {
        if (number1.text.toString().trim().isEmpty() || number2.text.toString().trim().isEmpty())
            return false

        return true
    }

    fun calcular(): Double {
        val numero1 = number1.text.toString().toDouble()
        val numero2 = number2.text.toString().toDouble()
        var total : Double = 0.0

        if (soma.isChecked) {
            total += numero1 + numero2
        }
        else if (subtracao.isChecked){
            total += numero1 - numero2
        }
        else if(multiplicacao.isChecked){
            total += numero1 * numero2
        }
        else{
            if(numero2 != 0.0){
                total += numero1/numero2
            }else{
                Toast.makeText(this, "Não é possível dividir por 0", Toast.LENGTH_SHORT).show()
            }

        }
        return total;
    }
}