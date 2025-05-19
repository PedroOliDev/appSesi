package com.example.appsesi;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

 EditText editTextEmail, editTextSenha, editTextNome;

 Button btnCriarConta, btnVoltar;

 TextView textErro;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextNome = findViewById(R.id.editTextNome);
        btnCriarConta = findViewById(R.id.btnCriarConta);
        btnVoltar = findViewById(R.id.btnVoltar);
        textErro = findViewById(R.id.textErro);

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();
                String nome = editTextNome.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha) || TextUtils.isEmpty(nome)) {
                    textErro.setText("Preencha todos os campos para realizar o cadastro");
                    return;
                } else if (email != null && senha != null && nome != null) {
                    Intent intent = new Intent(CreateActivity.this, LoginActivity.class);
                    intent.putExtra("emailNovo", email);
                    intent.putExtra("senhaNova", senha);
                    intent.putExtra("nomeNovo", nome); // Não implementado completamente.
                    startActivity(intent);
                    finish(); // fecha tela de login
                }


            }
        });
    }
}
