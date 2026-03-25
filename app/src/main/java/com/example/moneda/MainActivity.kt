package com.example.moneda

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editTextCantidad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextCantidad = findViewById(R.id.editTextText)
    }

    fun miClicManejador(view: View) {
        val texto = editTextCantidad.text.toString()
        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresa un monto", Toast.LENGTH_SHORT).show()
            return
        }

        val cantidad = texto.toFloat()
        var resultado = 0f
        var monedaNombre = ""

        // Lógica simple con los tipos de cambio actuales
        when {
            findViewById<RadioButton>(R.id.rbDolarASol).isChecked -> {
                resultado = cantidad * 3.75f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbSolADolar).isChecked -> {
                resultado = cantidad / 3.75f
                monedaNombre = "Dólares"
            }
            findViewById<RadioButton>(R.id.rbEuroASol).isChecked -> {
                resultado = cantidad * 4.05f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbLibraASol).isChecked -> {
                resultado = cantidad * 4.75f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbRupiaASol).isChecked -> {
                resultado = cantidad * 0.045f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbRealASol).isChecked -> {
                resultado = cantidad * 0.75f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbPesoASol).isChecked -> {
                resultado = cantidad * 0.22f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbYuanASol).isChecked -> {
                resultado = cantidad * 0.52f
                monedaNombre = "Soles"
            }
            findViewById<RadioButton>(R.id.rbYenASol).isChecked -> {
                resultado = cantidad * 0.025f
                monedaNombre = "Soles"
            }
        }

        Toast.makeText(this, "Resultado: ${"%.2f".format(resultado)} $monedaNombre", Toast.LENGTH_LONG).show()
    }
}