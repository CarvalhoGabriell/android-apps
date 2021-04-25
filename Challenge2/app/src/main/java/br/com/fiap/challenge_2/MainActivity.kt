package br.com.fiap.challenge_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSomar.setOnClickListener { _ : View? ->
             if (validarCampos()) {
                 val value1 = txtnum1.text.toString().toDouble()
                 val value2 = txtnum2.text.toString().toDouble()
                 val resultSoma : Double = value1 + value2

                 val telaResult = Intent(this, ResultActivity::class.java)
                 telaResult.putExtra("resultado", resultSoma)
                 startActivity(telaResult)
             }

        }
    }

    fun validarCampos() : Boolean {

        var msg = ""
        if (txtnum1.text.trim().isEmpty()) {
            msg = "Informe um número no campo 1"
        } else if (txtnum2.text.trim().isEmpty()) {
            msg = "Informe um número no campo 2"
        }
        if (msg.equals("")) {
            return true
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        return false
    }
}