package com.example.intentimplicito

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentimplicito.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregar.setOnClickListener {

            val intent = Intent (this, SegundaActivity::class.java)
            startActivity(intent)
        }

        binding.btnLlamar.setOnClickListener {
            val Emergencia = "112" // Es buena práctica manejar el número como String directamente.
            val intenLlamar = Intent(Intent.ACTION_DIAL)
            // --- CORRECCIÓN AQUÍ ---
            // Se añade "tel:" para que el sistema sepa que es un número de teléfono.
            intenLlamar.data = Uri.parse("tel:$Emergencia")
            startActivity(intenLlamar)
        }

    }
}

