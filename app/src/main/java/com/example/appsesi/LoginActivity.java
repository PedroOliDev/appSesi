package com.example.appsesi;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextSenha;
    Button btnLogin, btnCriarConta;
    TextView textErro;

    // Simulação de credencial fixa (para protótipo)
    private final String usuarioFixo = "usuario@sesi.com";
    private final String senhaFixa = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCriarConta = findViewById(R.id.btnCriarConta);
        textErro = findViewById(R.id.textErro);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String senha = editTextSenha.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
                    textErro.setText("Preencha todos os campos.");
                    return;
                }

                if (email.equals(usuarioFixo) && senha.equals(senhaFixa)) {
                    // Login bem-sucedido
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // fecha tela de login
                } else {
                    textErro.setText("E-mail ou senha incorretos.");
                }
            }
        });

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textErro.setText("Função de cadastro ainda não implementada.");
            }
        });
    }
}
