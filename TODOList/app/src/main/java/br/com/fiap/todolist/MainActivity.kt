package br.com.fiap.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    var tarefas = ArrayList<String>()

    var adapter : ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tarefas)
        listask.adapter = adapter

        btnFloat.setOnClickListener {
            adicionarTasks()
        }

        listask.setOnItemClickListener {parent, view, position, id ->
            var tarefa = parent.adapter.getItem(position).toString()
            atualizarTasks(tarefa, position)

        }
    }


    fun adicionarTasks() {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("New Task!")

        var inputDados =EditText(this)
        builder.setView(inputDados)

        builder.setPositiveButton("OK") { dialog, which ->
            tarefas.add(inputDados.text.toString())
            adapter?.notifyDataSetChanged()

        }
        builder.setNegativeButton("CANCEL", null)
        builder.create().show()
    }

    fun atualizarTasks(titulo: String, posicao : Int) {

        var builder = AlertDialog.Builder(this)
        builder.setTitle("Atualizar Task!")

        var editDados = EditText(this)
        builder.setView(editDados)

        builder.setPositiveButton("CONFIRM") { dialog, which ->
            tarefas[posicao] = editDados.text.toString()
            adapter?.notifyDataSetChanged()

        }
        builder.setNegativeButton("CANCEL", null)

        builder.setNeutralButton("EXCLUIR") { dialog, which ->
            tarefas.removeAt(posicao)
            adapter?.notifyDataSetChanged()
        }

        builder.create().show()
    }
}