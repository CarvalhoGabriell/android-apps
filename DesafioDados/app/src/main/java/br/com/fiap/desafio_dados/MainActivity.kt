package br.com.fiap.desafio_dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //image1.setImageResource(R.drawable.face1)
        btnJogar.setOnClickListener {
            val play1 = Random.nextInt(1,7)
            val play2 = Random.nextInt(1,7)
            image1.setImageResource(idImagemDado(play1))
            image2.setImageResource(idImagemDado(play2))
            var msg = ""
            if (play1 > play2) {
                msg = "Vencedor da Rodada: Jogador 1"
            }else if (play1 < play2) {
                msg = "Vencedor da Rodada: Jogador 2"
            }else {
                msg = "Empate nessa Rodada"
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }


    fun idImagemDado (valorID : Int) : Int{

        return when (valorID) {
            1 -> R.drawable.face1
            2 -> R.drawable.face2
            3 -> R.drawable.face3
            4 -> R.drawable.face4
            5 -> R.drawable.face5
            6 -> R.drawable.face6
            else -> R.drawable.face1
        }
    }
}