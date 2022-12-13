package ies.luiscarrillodesotomayor.autenticacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import ies.luiscarrillodesotomayor.autenticacion.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // boton de LOGIN
        binding.BEntrar.setOnClickListener {
            login()
        }

    }

    private fun login() {
        // si el correo y el password no estan vacios
        if (binding.TBCorreo.text.isNotEmpty() && binding.TBContraseA.text.isNotEmpty()) {

            // Iniciamos sesion con el metodo singIn y envviamos a Firebase el correo y el password
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                binding.TBCorreo.text.toString(),
                binding.TBContraseA.text.toString()
            )
                .addOnCompleteListener {
                    // si la autenticacion es correcta
                    if (it.isSuccessful) {
                      // Accedemos a la pantalla inicioActivity para dar la bienvenida
                        val intent = Intent(this, inicioActiviti::class.java)
                        startActivity(intent)

                    }
                    else {
                        // si no es correcta mostramos un mensaje de error
                        Toast.makeText(this, "Error al iniciar sesion", Toast.LENGTH_LONG).show()
                    }
                }

        }
        else {
            // si el correo o el password estan vacios mostramos un mensaje de error
            Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}

