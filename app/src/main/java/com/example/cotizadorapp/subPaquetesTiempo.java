package com.example.cotizadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class subPaquetesTiempo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinnerTiempo;
    String nombreCategoria;

    String[] nombresSubPaquetes;
    int[] preciosSubPaquetes;
    float[] subPaquetesTiempoPrecios;

    String subPaqueteSeleccionado;
    float precioSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_paquetes_tiempo);

        spinnerTiempo = (Spinner) findViewById(R.id.spinnerTiempo);

        Bundle datos = getIntent().getExtras();
        nombreCategoria = datos.getString("nombreCategoria");
        nombresSubPaquetes = datos.getStringArray("nombresSubPaquetes");
        preciosSubPaquetes = datos.getIntArray("preciosSubPaquetes");

        subPaquetesTiempoPrecios = new float[3];
        subPaquetesTiempoPrecios[0] = (float) (preciosSubPaquetes[0] * .25) + preciosSubPaquetes[0];
        subPaquetesTiempoPrecios[1] = (float) (preciosSubPaquetes[1] * .30) + preciosSubPaquetes[1];
        subPaquetesTiempoPrecios[2] = (float) (preciosSubPaquetes[2] * .35) + preciosSubPaquetes[2];

        String[] paquetesTiempo = { "$"+subPaquetesTiempoPrecios[0]+" por un mes",
                "$"+subPaquetesTiempoPrecios[1]+" por dos meses",
                "$"+subPaquetesTiempoPrecios[2]+" por tres meses"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paquetesTiempo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiempo.setAdapter(adapter);
    }
    public void eligeOtraCategoria(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void continuaSubPaqueteSeleccionado(View view){

        Intent i = new Intent(this, calculaTotalResumen.class);
        i.putExtra("nombreCategoria", this.nombreCategoria);
        i.putExtra("nombreSubPaquete", subPaqueteSeleccionado);
        i.putExtra("precioSubPaquete", precioSeleccionado);
        startActivity(i);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        switch (pos){
            case 0:
                subPaqueteSeleccionado = nombresSubPaquetes[0];
                precioSeleccionado = subPaquetesTiempoPrecios[0];
                break;
            case 1:
                subPaqueteSeleccionado = nombresSubPaquetes[1];
                precioSeleccionado = subPaquetesTiempoPrecios[1];
                break;
            case 2:
                subPaqueteSeleccionado = nombresSubPaquetes[2];
                precioSeleccionado = subPaquetesTiempoPrecios[2];
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}