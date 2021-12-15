package com.mcas2.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lDivisas;
    private ArrayList<Double> facCambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillDivisas();
        fillCambios();

        RecyclerView rvDivisas = findViewById(R.id.rvDivisas);
        LinearLayoutManager managerLayout = new LinearLayoutManager(this);
        rvDivisas.setLayoutManager(managerLayout);
        MiAdaptador adaptador = new MiAdaptador(this, lDivisas);
        rvDivisas.setAdapter(adaptador);
    }

    private void fillDivisas (){
        lDivisas.add("USD");
        lDivisas.add("GBP");
        lDivisas.add("CAD");
        lDivisas.add("AUD");
        lDivisas.add("JPY");
        lDivisas.add("INR");
        lDivisas.add("NZD");
        lDivisas.add("CHF");
        lDivisas.add("ZAR");
        lDivisas.add("RUB");
    }

    private void fillCambios (){
        facCambio.add(1.1293946);
        facCambio.add(0.85447758);
        facCambio.add(1.4339265);
        facCambio.add(1.5788175);
        facCambio.add(128.17384);
        facCambio.add(85.36992);
        facCambio.add(1.6631981);
        facCambio.add(1.0441295);
        facCambio.add(18.030472);
        facCambio.add(83.219626);
    }
}