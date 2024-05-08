package com.example.discotecaproyectofinal;

import android.os.Bundle;
import android.widget.TextView; // Importa la clase TextView
import java.util.Locale; // Importa la clase Locale para el formateo de números
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class DetalleReserva extends AppCompatActivity {

    private static final double PRECIO_PISO_PRIMER = 50.0; // Precio por mesa en el primer piso
    private static final double PRECIO_PISO_SEGUNDO = 70.0; // Precio por mesa en el segundo piso
    private static final double PRECIO_COMBO = 25.0; // Precio del combo inicial por persona

    private String nombre;
    private int numMesas;
    private boolean primerPiso;
    private boolean segundoPiso;
    private boolean comboInicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Recuperar los datos de la reserva del Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombre = extras.getString("nombre");
            numMesas = extras.getInt("num_mesas");
            primerPiso = extras.getBoolean("primer_piso");
            segundoPiso = extras.getBoolean("segundo_piso");
            comboInicial = extras.getBoolean("combo_inicial");
        }

        // Mostrar los detalles de la reserva
        mostrarDetallesReserva();

        // Calcular y mostrar el precio total
        calcularYMostrarPrecioTotal();
    }

    private void mostrarDetallesReserva() {
        // Mostrar el nombre de la reserva
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        textViewNombre.setText(nombre);

        // Mostrar el número de mesas
        TextView textViewNumMesas = findViewById(R.id.textViewNumMesas);
        textViewNumMesas.setText("Número de Mesas: " + numMesas);

        // Mostrar el piso seleccionado
        TextView textViewPiso = findViewById(R.id.textViewPiso);
        if (primerPiso) {
            textViewPiso.setText("Piso: Primer Piso");
        } else if (segundoPiso) {
            textViewPiso.setText("Piso: Segundo Piso");
        } else {
            textViewPiso.setText("Piso: No especificado");
        }

        // Mostrar si se eligió el combo inicial
        TextView textViewComboInicial = findViewById(R.id.textViewComboInicial);
        if (comboInicial) {
            textViewComboInicial.setText("Combo Inicial: Sí");
        } else {
            textViewComboInicial.setText("Combo Inicial: No");
        }
    }

    private void calcularYMostrarPrecioTotal() {
        // Calcular el precio total basado en las selecciones del usuario
        double precioTotal = 0.0;

        // Calcular el precio por mesas y sumarlo al precio total
        if (primerPiso) {
            precioTotal += numMesas * PRECIO_PISO_PRIMER;
        } else if (segundoPiso) {
            precioTotal += numMesas * PRECIO_PISO_SEGUNDO;
        }

        // Sumar el precio del combo inicial si fue seleccionado
        if (comboInicial) {
            precioTotal += numMesas * PRECIO_COMBO;
        }

        // Mostrar el precio total
        TextView textViewPrecioTotal = findViewById(R.id.textViewPrecioTotal);
        textViewPrecioTotal.setText("Precio Total: $" + String.format(Locale.getDefault(), "%.2f", precioTotal));
    }
}
