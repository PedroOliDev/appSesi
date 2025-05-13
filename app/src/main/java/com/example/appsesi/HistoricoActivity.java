package com.example.appsesi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.*;

public class HistoricoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Presenca> listaPresencas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Simulando dados
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        listaPresencas.add(new Presenca("João Silva", sdf.format(new Date())));
        listaPresencas.add(new Presenca("Maria Oliveira", sdf.format(new Date())));

        PresencaAdapter adapter = new PresencaAdapter(listaPresencas);
        recyclerView.setAdapter(adapter);
    }
}

