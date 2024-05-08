package com.example.discotecaproyectofinal;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

public class TiempoRestanteActivity extends AppCompatActivity {

    private TextView textViewTiempoRestante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo_restante);

        textViewTiempoRestante = findViewById(R.id.textViewTiempoRestante);

        // Calcula el tiempo restante en milisegundos
        long millisInFuture = TimeUnit.DAYS.toMillis(10); // 10 días
        long countDownInterval = 1000; // Intervalo de actualización cada segundo

        // Inicia el cronómetro
        new CountDownTimer(millisInFuture, countDownInterval) {
            public void onTick(long millisUntilFinished) {
                // Calcula los días, horas, minutos y segundos restantes
                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60;
                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60;

                // Actualiza el texto del TextView
                String countdownText = String.format("%02d:%02d:%02d:%02d", days, hours, minutes, seconds);
                textViewTiempoRestante.setText(countdownText);
            }

            public void onFinish() {
                // Acciones a realizar cuando el cronómetro termina (opcional)
                textViewTiempoRestante.setText("00:00:00:00"); // Puedes cambiar el texto si deseas
            }
        }.start(); // Inicia el cronómetro
    }
}
