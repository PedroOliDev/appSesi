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

    // Simulação de credencial fixa (para TESTES!! E UMA FALHA DE SEGURANÇA A LONGO PRAZO!!!)
    private final String usuarioFixo = "usuario@sesi.com";

    public String[] emailNovo = {};

    public String[] senhaNova = {};
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

                Intent incomingIntent = getIntent();

                String receivedEmail = incomingIntent.getStringExtra("emailNovo");
                String receivedSenha = incomingIntent.getStringExtra("senhaNova");

                if (receivedEmail != null && receivedSenha != null) {
                    emailNovo = new String[]{receivedEmail};
                    senhaNova = new String[]{receivedSenha};
                }

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(senha)) {
                    textErro.setText("Preencha todos os campos.");
                    return;
                }

                // Verificação se estão corretas as credenciais.
                if (email.equals(usuarioFixo) && senha.equals(senhaFixa) || email.equals(emailNovo[0]) && senha.equals(senhaNova[0])) {
                    // Login bem-sucedido
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // fecha tela de login
                } else {
                    textErro.setText("E-mail ou senha incorretos.");
                }
            }
        });
        //

        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Selecionando a criação de entradas.
                Intent intent = new Intent(LoginActivity.this, CreateActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
