package com.marcelo.blocodenotas

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.marcelo.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencia = PreferenciaAnotacao(applicationContext)
        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener {
            val anotaoRecuperado = binding.editContainer.editAnotacao.text.toString()

            if (anotaoRecuperado.isEmpty()){
                Toast.makeText(this, "Digite alguma coisa", Toast.LENGTH_LONG).show()
            } else {
                preferencia.SalvarAnotacao(anotaoRecuperado)
                Toast.makeText(this, "Anotação foi salva com sucesso", Toast.LENGTH_LONG).show()
            }
        }

        val anotacao = preferencia.RecuperarAnotacao()
        if (anotacao!!.isNotEmpty()){
            binding.editContainer.editAnotacao.setText(anotacao)
        }
    }
}