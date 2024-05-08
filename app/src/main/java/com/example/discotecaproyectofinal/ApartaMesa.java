package com.example.discotecaproyectofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ApartaMesa extends AppCompatActivity {

    private Spinner spinnerPiso;
    private Spinner spinnerNumeroMesa;
    private Button btnCalcularPrecio;
    private TextView textViewPrecioTotal;

    private static final double PRECIO_BASE = 50.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aparta_mesa);

        spinnerPiso = findViewById(R.id.spinnerPiso);
        spinnerNumeroMesa = findViewById(R.id.spinnerNumeroMesa);
        btnCalcularPrecio = findViewById(R.id.btnCalcularPrecio);
        textViewPrecioTotal = findViewById(R.id.textViewPrecioTotal);

        ArrayAdapter<CharSequence> adapterPiso = ArrayAdapter.createFromResource(this,
                R.array.pisos_array, android.R.layout.simple_spinner_item);
        adapterPiso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPiso.setAdapter(adapterPiso);

        ArrayAdapter<CharSequence> adapterNumeroMesa = ArrayAdapter.createFromResource(this,
                R.array.numero_mesas_array, android.R.layout.simple_spinner_item);
        adapterNumeroMesa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumeroMesa.setAdapter(adapterNumeroMesa);

        btnCalcularPrecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double precioTotal = calcularPrecio();
                textViewPrecioTotal.setText("Precio Total: $" + precioTotal);
            }
        });
    }

    private double calcularPrecio() {
        int piso = spinnerPiso.getSelectedItemPosition() + 1;
        int numeroMesa = spinnerNumeroMesa.getSelectedItemPosition() + 1;

        double precioPorPiso;
        if (piso == 1) {
            precioPorPiso = PRECIO_BASE * 0.8;
        } else if (piso == 2) {
            precioPorPiso = PRECIO_BASE * 1.0;
        } else {
            precioPorPiso = PRECIO_BASE * 1.2;
        }

        double precioPorMesa = calcularPrecioPorMesa(numeroMesa);

        return precioPorPiso + precioPorMesa;
    }

    private double calcularPrecioPorMesa(int numeroMesa) {
        return numeroMesa * 5.0;
    }
}
