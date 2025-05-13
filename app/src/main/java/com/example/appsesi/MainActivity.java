package com.example.appsesi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    Button btnMarcarPresenca;
    ProgressBar progressBar;
    TextView textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // nome do XML

        editTextNome = findViewById(R.id.editTextNome);
        btnMarcarPresenca = findViewById(R.id.btnMarcarPresenca);
        progressBar = findViewById(R.id.progressBar);
        textStatus = findViewById(R.id.textStatus);

        btnMarcarPresenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                if (nome.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite seu nome", Toast.LENGTH_SHORT).show();
                } else {
                    marcarPresenca();
                }
            }
        });
    }

    private void marcarPresenca() {
        btnMarcarPresenca.setEnabled(false);
        progressBar.setVisibility(View.VISIBLE);
        textStatus.setText("Aguardando confirmação...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                textStatus.setText("Presença confirmada!");
                btnMarcarPresenca.setEnabled(true);
            }
        }, 3000); // 3 segundos
    }
}
