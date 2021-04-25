package br.com.fiap.checkpoint_2tdst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_conta_telefonica.*

/*
GABRIEL CARVALHO FERNANDES
THALITA FEITOSA DA SILVA
MATEUS RAMOS MARTINS
 */

class ResultadoContaTelefonicaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_conta_telefonica)

        txtResultado.text = intent.getStringExtra("msg")
    }
}