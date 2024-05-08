package com.example.discotecaproyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class contacto extends AppCompatActivity {

    EditText editTextNombre, editTextEmail, editTextEdad, editTextTelefono, editTextMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextMensaje = findViewById(R.id.editTextMensaje);

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados en los EditText
                String nombre = editTextNombre.getText().toString();
                String email = editTextEmail.getText().toString();
                String edad = editTextEdad.getText().toString();
                String telefono = editTextTelefono.getText().toString();
                String mensaje = editTextMensaje.getText().toString();

                // Crear un Intent para pasar los datos a la actividad "RegistroExitosamente"
                Intent intent = new Intent(contacto.this, RegistroExitosamente.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("email", email);
                intent.putExtra("edad", edad);
                intent.putExtra("telefono", telefono);
                intent.putExtra("mensaje", mensaje);
                startActivity(intent);
            }
        });

        Button buttonBackToMain = findViewById(R.id.buttonBackToMain);
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contacto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
