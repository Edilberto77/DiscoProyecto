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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencias a los botones
        Button productosButton = findViewById(R.id.buttonProducto);
        Button eventosButton = findViewById(R.id.buttoneventos);
        Button djArtistasButton  = findViewById(R.id.buttondjartistas);
        Button promocionesButton = findViewById(R.id.buttonpromociones);
        Button contactosButton = findViewById(R.id.buttoncontacto);

        // Establecer listeners de clic para cada botón
        productosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón Producto
                Intent intent = new Intent(MainActivity.this, Productos.class);
                startActivity(intent);
            }
        });

        eventosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón Evento
                Intent intent = new Intent(MainActivity.this, Eventos.class);
                startActivity(intent);
            }
        });

        djArtistasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón DJ/Artistas
                Intent intent = new Intent(MainActivity.this, Djartistas.class);
                startActivity(intent);
            }
        });

        promocionesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón Promociones
                Intent intent = new Intent(MainActivity.this, promociones.class);
                startActivity(intent);
            }
        });

        contactosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón Contacto
                Intent intent = new Intent(MainActivity.this, contacto.class);
                startActivity(intent);
            }
        });
    }
}
