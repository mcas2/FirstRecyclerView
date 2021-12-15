package com.mcas2.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.ViewHolder> {

    private ArrayList<String> lDivisas;
    private LayoutInflater inflater;

    MiAdaptador(Context context, ArrayList<String> lDivisas){
        this.lDivisas = lDivisas;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String divisa = lDivisas.get(position);
        holder.tvDivisa.setText(divisa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return lDivisas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDivisa;

        public ViewHolder(@NonNull View item) {
            super(item);
            tvDivisa = item.findViewById(R.id.tvDivisa);
        }
    }

}
