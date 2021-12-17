package com.mcas2.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> lDivisas = new ArrayList<>();
    private ArrayList<Double> facCambio = new ArrayList<>();

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

        DividerItemDecoration decorator = new DividerItemDecoration(
                rvDivisas.getContext(), managerLayout.getOrientation());
        rvDivisas.addItemDecoration(decorator);


        Switch switchVIP = (Switch) findViewById(R.id.switchVIP);

        Button convertir = (Button) findViewById(R.id.convertir);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar(switchVIP.isChecked(), adaptador.getElementoSeleccionado());
            }
        });


        switchVIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiar(switchVIP.isChecked(), adaptador.getElementoSeleccionado());
            }
        });
    }

    public void cambiar(boolean VIP, int posicion){
        TextView resultado = findViewById(R.id.resultado);
        if (posicion!=-1){
            try {
                EditText etCantidad = (EditText) findViewById(R.id.entradaEuros);
                double euros = Double.parseDouble(etCantidad.getText().toString());
                double cambio = VIP? facCambio.get(posicion):facCambio.get(posicion)*1.01;
                resultado.setText(""+cambio*euros);
            } catch (NumberFormatException e){
                resultado.setText("Introduce un dato válido");
            }
        }
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