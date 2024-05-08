package com.example.discotecaproyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class promociones extends AppCompatActivity {

    // Supongamos que la promoción finaliza en 10 días
    private int diasRestantes = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_promociones);

        // Aplicar padding para los insets de la ventana
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
                Intent intent = new Intent(promociones.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Obtener referencia al botón "Tiempo Restante"
        Button textViewDiasRestantes = findViewById(R.id.textViewDiasRestantes);

        // Configurar un OnClickListener para el botón "Tiempo Restante"
        textViewDiasRestantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad de tiempo restante
                Intent intent = new Intent(promociones.this, TiempoRestanteActivity.class);
                startActivity(intent);
            }
        });

        // Mostrar la cantidad de días restantes en la promoción
         textViewDiasRestantes = findViewById(R.id.textViewDiasRestantes);
        textViewDiasRestantes.setText("Faltan " + diasRestantes + " días para que se acabe la promoción");
    }
}
