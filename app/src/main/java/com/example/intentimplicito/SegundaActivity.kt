package com.example.intentimplicito

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentimplicito.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregarContacto.setOnClickListener {
            val nombre = binding.txtNombre.text.toString()
            val telefono = binding.txtTel.text.toString()
            val correo = binding.txtCorreo.text.toString()

            val intent = Intent(Intent.ACTION_INSERT).apply{
                type = "vnd.android.cursor.dir/contact"
                putExtra(android.provider.ContactsContract.Intents.Insert.NAME, nombre)
                putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, telefono)
                putExtra(android.provider.ContactsContract.Intents.Insert.EMAIL, correo)

                startActivity(Intent.createChooser(this,"Crear contacto"))
            }

        }

        }
    }
