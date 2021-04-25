package br.com.fiap.checkpoint_2tdst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculadora.*
import kotlinx.android.synthetic.main.activity_telefone.*

/*
GABRIEL CARVALHO FERNANDES
THALITA FEITOSA DA SILVA
MATEUS RAMOS MARTINS
 */


class TelefoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telefone)
    }

    fun btnCalcularClick(view: View) {
        var msgRetorno = ""
        if (validarCampos()) {
            var minLocal = numMinLocal.text.toString().toDouble()
            var minCelular = numMinCelular.text.toString().toDouble()
            var assinatura = numAssinatura.text.toString().toDouble()

            var qtdLocal = minLocal * 0.04
            var qtdCelular = minCelular * 0.20

            var tot = assinatura + qtdCelular + qtdLocal

            msgRetorno = formatarMsg(
                qtdLocal.toString(),
                qtdCelular.toString(),
                assinatura.toString(),
                tot.toString()
            )
        }
        else{
            msgRetorno = "Dados Vazios, Por favor volte e preencha todos os campos."
        }

        transicaoActivity(view, msgRetorno)
    }

    fun formatarMsg(minLocal : String, minCelular: String, assinatura :String, total :String) : String{

        return "Assinatura:        R$ ${assinatura}\n" +
                "Chamada Local:    R\$ ${minLocal}\n" +
                "Chamada Celular:  R\$ ${minCelular}\n\n" +
                "Valor Total:      R\$ ${total}"
    }

    fun transicaoActivity(view: View, msgRetorno: String){

        var telaResultado = Intent(this, ResultadoContaTelefonicaActivity::class.java)
        telaResultado.putExtra("msg", msgRetorno)
        startActivity(telaResultado)
    }

    fun validarCampos(): Boolean {
        if (numMinLocal.text.toString().trim().isEmpty()
            || numMinCelular.text.toString().trim().isEmpty()
            || numAssinatura.text.toString().trim().isEmpty())
            return false

        return true
    }
}