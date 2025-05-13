package com.example.appsesi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PresencaAdapter extends RecyclerView.Adapter<PresencaAdapter.ViewHolder> {

    private List<Presenca> presencaList;

    public PresencaAdapter(List<Presenca> presencaList) {
        this.presencaList = presencaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_presenca, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Presenca p = presencaList.get(position);
        holder.nome.setText(p.getNome());
        holder.dataHora.setText(p.getDataHora());
    }

    @Override
    public int getItemCount() {
        return presencaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, dataHora;

        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNomePresenca);
            dataHora = itemView.findViewById(R.id.txtDataHora);
        }
    }
}

