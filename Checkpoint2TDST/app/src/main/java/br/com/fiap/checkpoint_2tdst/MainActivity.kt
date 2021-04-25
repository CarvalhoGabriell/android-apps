package br.com.fiap.checkpoint_2tdst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

/*
GABRIEL CARVALHO FERNANDES
THALITA FEITOSA DA SILVA
MATEUS RAMOS MARTINS
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mostrar(view: View) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Desenvolvido por: ").setMessage("Gabriel Carvalho Fernandes \nThalita Feitosa da Silva \nMateus Ramos Martins").setPositiveButton("OK", null)
        builder.create().show()
    }

    fun calcular(view: View) {
        val msgRetorno = "Selecione uma Operação: "
        var telaCalculadora = Intent(this, CalculadoraActivity::class.java)
        telaCalculadora.putExtra("msg", msgRetorno)
        startActivity(telaCalculadora)

    }

    fun contaTelefonica(view: View){
        val msgRetorno = ""
        var telaContaTelefonica = Intent(this, TelefoneActivity::class.java)
        telaContaTelefonica.putExtra("msg", msgRetorno)
        startActivity(telaContaTelefonica)
    }
}