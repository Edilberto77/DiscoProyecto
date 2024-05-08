package com.example.discotecaproyectofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Apartarproducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartarproducto);

        // Obtener referencias a los elementos de la interfaz de usuario
        EditText editTextNombreProducto = findViewById(R.id.editTextNombreProducto);
        EditText editTextCantidad = findViewById(R.id.editTextCantidad);
        EditText editTextPrecioUnitario = findViewById(R.id.editTextPrecioUnitario);
        EditText editTextDescripcion = findViewById(R.id.editTextDescripcion);
        Button buttonApartar = findViewById(R.id.buttonApartar);
        TextView textViewResultado = findViewById(R.id.textViewResultado);

        // Configurar un OnClickListener para el botón "Apartar"
        buttonApartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario
                String nombreProducto = editTextNombreProducto.getText().toString();
                int cantidad = Integer.parseInt(editTextCantidad.getText().toString());
                double precioUnitario = Double.parseDouble(editTextPrecioUnitario.getText().toString());
                String descripcion = editTextDescripcion.getText().toString();

                // Calcular el precio total
                double precioTotal = cantidad * precioUnitario;

                // Crear el mensaje de resultado
                String resultado = "Producto: " + nombreProducto + "\n"
                        + "Cantidad: " + cantidad + "\n"
                        + "Precio Unitario: $" + precioUnitario + "\n"
                        + "Descripción: " + descripcion + "\n"
                        + "Precio Total: $" + precioTotal;

                // Mostrar el resultado en el TextView
                textViewResultado.setText(resultado);
            }
        });

        // Obtener referencia al botón "Cancelar"
        Button buttonCancelar = findViewById(R.id.buttonCancelar);

        // Configurar un OnClickListener para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cerrar la actividad actual
                finish();
            }
        });
    }
}
