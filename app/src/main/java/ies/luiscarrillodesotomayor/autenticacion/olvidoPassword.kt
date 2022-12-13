package ies.luiscarrillodesotomayor.autenticacion


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ies.luiscarrillodesotomayor.autenticacion.databinding.OlvidopasswordBinding

class olvidoPassword : AppCompatActivity() {

    private lateinit var binding: OlvidopasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OlvidopasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}