package com.example.appsesi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    TextView txtNome, txtMatricula, txtEmail;
    ImageView imgPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtNome = findViewById(R.id.txtNome);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtEmail = findViewById(R.id.txtEmail);
        imgPerfil = findViewById(R.id.imgPerfil);

        // Dados simulados
        txtNome.setText("Pedro");
        txtMatricula.setText("Matrícula: 20251234");
        txtEmail.setText("usuario@sesi.com");
    }
}
