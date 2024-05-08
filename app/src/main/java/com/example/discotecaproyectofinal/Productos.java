package com.example.discotecaproyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        // Configurar el padding para el contenido bajo los sistemas de barra
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener referencia al botón "Volver al Menú Principal"
        Button buttonBackToMain = findViewById(R.id.buttonBackToMain);

        // Configurar un OnClickListener para el botón "Volver al Menú Principal"
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad del menú principal
                Intent intent = new Intent(Productos.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Obtener referencia al botón para abrir la ventana de ApartarProducto
        Button buttonbuttonapartarproducto = findViewById(R.id.buttonapartarproducto);

        // Configurar un OnClickListener para el botón para abrir la ventana de ApartarProducto
        buttonbuttonapartarproducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de ApartarProducto
                Intent intent = new Intent(Productos.this, Apartarproducto.class);
                startActivity(intent);
            }
        });
    }
}