package br.com.fiap.desafio_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun botaoMudarImagens(view : View) {
        when (view.id) {
            R.id.btn1 -> img.setImageResource(R.drawable.linux)
            R.id.btn2 -> img.setImageResource(R.drawable.dragon)
            R.id.btn3 -> img.setImageResource(R.drawable.drog)
        }

    }


    // Fazendo do jeito mais facil e mais simples
//    fun botaoMudarImag1(view: View) {
//        img.setImageResource(R.drawable.linux)
//    }
//    fun botaoMudarImag2(view: View) {
//        img.setImageResource(R.drawable.dragon)
//    }
//    fun botaoMudarImag3(view: View) {
//        img.setImageResource(R.drawable.drog)
//    }
}