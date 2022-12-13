package ies.luiscarrillodesotomayor.autenticacion


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.luiscarrillodesotomayor.autenticacion.databinding.InicioactivityBinding

class inicioActiviti : AppCompatActivity() {

    private lateinit var binding: InicioactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = InicioactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Pasamos los datos del usuario registrado a la ventana de inicio
        val extras = intent.extras
        val nombre = extras?.getString("nombre")

        // cambio el label con el nombre del usuario
        binding.textView2.text = "Bienvenido $nombre"
    }
}