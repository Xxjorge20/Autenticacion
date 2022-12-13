package ies.luiscarrillodesotomayor.autenticacion


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import com.google.firebase.auth.FirebaseAuth
import ies.luiscarrillodesotomayor.autenticacion.databinding.RegistroactivityBinding


class registroActivity : AppCompatActivity() {

     private lateinit var binding: RegistroactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cambiar titulo de ventana
        title = "Registro"

        // Boton para registrar usuarios
        binding.BRegistrarUsuario.setOnClickListener {
            registrar()
        }

    }


    private fun registrar(){
        if (binding.TBNombreRegistro.text.isNotEmpty() && binding.TBApellidosRegistro.text.isNotEmpty() && binding.TBEmailRegistro.text.isNotEmpty() && binding.TBContraseARegistro.text.isNotEmpty()) {

            // Registrar usuario con el metodo singUp y envviamos a Firebase el correo y el password
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                binding.TBEmailRegistro.text.toString(),
                binding.TBContraseARegistro.text.toString()
            )
                .addOnCompleteListener {
                    // si la autenticacion es correcta
                    if (it.isSuccessful) {
                        val intent = Intent(this, inicioActiviti::class.java).apply{
                            putExtra("nombre", binding.TBNombreRegistro.text.toString())
                        }
                        startActivity(intent)
                    }
                    //si no es correcta muestro un mensaje de error
                    else
                    {
                        Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_LONG).show()
                    }
                }

        }
        else
        {
            // si el correo o el password estan vacios mostramos un mensaje de error
            Toast.makeText(this, "Por favor rellene todos los campos", Toast.LENGTH_LONG).show()
        }
    }

}