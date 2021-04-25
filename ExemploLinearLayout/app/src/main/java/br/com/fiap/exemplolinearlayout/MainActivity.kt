package br.com.fiap.exemplolinearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cliqueBotao(view: View) {

        if (txtNome.text.trim().isEmpty()) {
            Toast.makeText(this, "Informe seu nome primeiro.", Toast.LENGTH_SHORT).show()
        } else {
            val msg = "Olá ${txtNome.text}"
            exibirMensagem("SAUDAÇÃO COM POP-UP", msg)
        }
    }

    fun exibirMensagem(title: String ,mensagem:String) {
        val build = AlertDialog.Builder(this)
        build
            .setTitle(title)
            .setMessage(mensagem)
            .setPositiveButton("OK", null)
        build.create().show()
    }
}