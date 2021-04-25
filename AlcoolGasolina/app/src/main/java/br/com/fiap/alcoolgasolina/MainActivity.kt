package br.com.fiap.alcoolgasolina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{view : View? ->
            // declarar o tipo da variavel explicitamente
            var precoAlcool = txtPrecoAll.text.toString().toDouble()
            var precoGsolina = txtPrecoGaso.text.toString().toDouble()

            // declarar o tipo da variavel implicitamente
            var  calculoFinal: Double = precoAlcool/precoGsolina
            var msgRetorno = ""
            if (calculoFinal > 0.7) {
                msgRetorno = "Compensa abastecer com Gasolina"
            } else if (calculoFinal < 0.7) {
                msgRetorno = "Compensa abastecer com Álcool"
            } else {
                msgRetorno = "NENHUM DOS DOIS"
            }
            // Enviar os dados de reultado para uma outra tela.
           var telaResultado = Intent(this, ResultActivity::class.java)
            telaResultado.putExtra("msg", msgRetorno)
            startActivity(telaResultado)
        }

        // Modo de recuperar valores usando o findById e sem o kotlin-extensions
//        var calcular = findViewById<Button>(R.id.btnCalcular)
//        calcular.setOnClickListener{view : View? ->
//
//            // declarar o tipo da variavel explicitamente
//            var txtAlcool = findViewById<EditText>(R.id.txtPrecoAll)
//            var precoAlcool = txtAlcool.text.toString().toDouble()
//            var txtGasolina = findViewById<EditText>(R.id.txtPrecoGaso)
//            var precoGsolina = txtGasolina.text.toString().toDouble()
//
//            // declarar o tipo da variavel implicitamente
//            var calculoFinal : Double = precoAlcool/precoGsolina
//
//            var msgRetorno = ""
//            if (calculoFinal > 0.7) {
//                msgRetorno = "Compensa mais abastecer com Gasolina"
//            } else if (calculoFinal < 0.7) {
//                msgRetorno = "Compensa mais abastecer com  Álcool"
//            } else {
//                msgRetorno = "NENHUM DOS DOIS"
//            }
//            Toast.makeText(this, msgRetorno, Toast.LENGTH_SHORT).show()
//        }
    }
}