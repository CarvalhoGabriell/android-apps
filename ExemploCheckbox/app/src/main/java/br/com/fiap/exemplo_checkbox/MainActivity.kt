package br.com.fiap.exemplo_checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itensSpinner = arrayOf<String>("Selecione", "Residencial", "Comercial", "Celular")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itensSpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoPhone.adapter = adapter

        btnMostrarMsg.setOnClickListener {
            if (validarCampos()) {
                var alert = """Nome Usuário: ${txtNome.text}
                        |Phone: ${txtPhone.text}
                        |Tipo Phone: ${spinnerTipoPhone.selectedItem}
                        |Email: ${txtEmail.text}
                        |Preferências de Contato:
                        """.trimMargin("|")
                if (cbPhone.isChecked) {
                    alert += "\n - Telefone"
                }
                if (cbEmail.isChecked) {
                    alert += "\n - Email"
                }
                alertMsg("Cadastrando Usuário",alert)
            }
        }
    }

    fun validarCampos(): Boolean {
        if (txtNome.text.trim().isEmpty() || txtPhone.text.trim().isEmpty() || txtEmail.text.trim().isEmpty() || spinnerTipoPhone.selectedItemPosition == 0) {
            Toast.makeText(this, "Todos os campos devem ser preenchidos",Toast.LENGTH_SHORT )
            return false
        }
        return true
    }


    fun alertMsg(titulo: String, msg : String) {
        val build = AlertDialog.Builder(this)
        build
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)
        build.create().show()
    }
}