package ies.luiscarrillodesotomayor.autenticacion


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
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

        binding.BCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            // Volver a la ventana de inicio
            startActivity(Intent(this, MainActivity::class.java))
            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_LONG).show()
        }


    }
}