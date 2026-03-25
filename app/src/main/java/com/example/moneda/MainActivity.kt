package com.example.moneda

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCantidad: EditText
    private lateinit var radioDolares: RadioButton
    private lateinit var radioSoles: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        editTextCantidad = findViewById(R.id.editTextText)
        radioDolares = findViewById(R.id.rbDolares)
        radioSoles = findViewById(R.id.rbSoles)
    }

    // Función principal de conversión
    private fun convertirMoneda() {
        val cantidadTexto = editTextCantidad.text.toString().trim()

        if (cantidadTexto.isEmpty()) {
            Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show()
            return
        }

        val cantidad = cantidadTexto.toFloatOrNull()
        if (cantidad == null || cantidad <= 0) {
            Toast.makeText(this, "Número no válido", Toast.LENGTH_SHORT).show()
            return
        }

        val tipoCambio = 3.65f

        if (radioDolares.isChecked) {
            val resultado = cantidad * tipoCambio
            val mensaje = "${"%.2f".format(cantidad)} USD son ${"%.2f".format(resultado)} Soles"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        } else if (radioSoles.isChecked) {
            val resultado = cantidad / tipoCambio
            val mensaje = "${"%.2f".format(cantidad)} Soles son ${"%.2f".format(resultado)} USD"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }


    fun miClicManejador(view: View) {
        if (view.id == R.id.btnConvertir) {
            convertirMoneda()
        }
    }
}