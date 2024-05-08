package com.example.discotecaproyectofinal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroExitosamente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_exitosamente);

        // Recuperar los datos del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String email = extras.getString("email");
            String edad = extras.getString("edad");
            String telefono = extras.getString("telefono");
            String mensaje = extras.getString("mensaje");

            // Mostrar los datos en los TextViews correspondientes
            TextView textViewDatosRegistrados = findViewById(R.id.textViewDatosRegistrados);
            String datos = "Nombre: " + nombre + "\n" +
                    "Email: " + email + "\n" +
                    "Edad: " + edad + "\n" +
                    "Teléfono: " + telefono + "\n" +
                    "Mensaje: " + mensaje;
            textViewDatosRegistrados.setText(datos);
        }

        // Obtener referencia al botón de apartar mesa
        Button btnApartarMesa = findViewById(R.id.btnApartarMesa);
        btnApartarMesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes agregar la lógica para apartar la mesa
                // Por ejemplo, puedes abrir una nueva actividad o ejecutar alguna acción
                // relacionada con la reserva de mesa.
                // Puedes usar un Intent para abrir otra actividad:
                Intent intent = new Intent(RegistroExitosamente.this, ApartaMesa.class);
                startActivity(intent);
            }
        });
    }
}

