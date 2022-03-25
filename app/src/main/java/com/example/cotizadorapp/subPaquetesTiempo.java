package com.example.cotizadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class subPaquetesTiempo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinnerTiempo;
    TextView titulo;

    float[] subPaquetesTiempoPrecios;
    float precioSeleccionado;
    int tiempoPaquete;

    String nombreCategoria;
    String nombreSubPaquete;
    int precioSubPaquete;
    boolean promocionActiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_paquetes_tiempo);

        spinnerTiempo = (Spinner) findViewById(R.id.spinnerTiempo);
        titulo = (TextView) findViewById(R.id.tituloSubPaqueteTiempo);

        Bundle datos = getIntent().getExtras();

        nombreCategoria = datos.getString("nombreCategoria");
        nombreSubPaquete = datos.getString("nombreSubPaquete");
        precioSubPaquete = datos.getInt("precioSubPaquete");
        promocionActiva = datos.getBoolean("promocion");

        titulo.setText(nombreCategoria + " | " + nombreSubPaquete);

        subPaquetesTiempoPrecios = new float[3];
        subPaquetesTiempoPrecios[0] = (float) (precioSubPaquete * .25) + precioSubPaquete;
        subPaquetesTiempoPrecios[1] = (float) (precioSubPaquete * .30) + precioSubPaquete;
        subPaquetesTiempoPrecios[2] = (float) (precioSubPaquete * .35) + precioSubPaquete;

        String[] paquetesTiempo = { "$"+subPaquetesTiempoPrecios[0]+" por un mes",
                "$"+subPaquetesTiempoPrecios[1]+" por dos meses",
                "$"+subPaquetesTiempoPrecios[2]+" por tres meses"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paquetesTiempo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTiempo.setAdapter(adapter);
        spinnerTiempo.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (pos){
            case 0:
                tiempoPaquete = 1;
                precioSeleccionado = subPaquetesTiempoPrecios[0];
                break;
            case 1:
                tiempoPaquete = 2;
                precioSeleccionado = subPaquetesTiempoPrecios[1];
                break;
            case 2:
                tiempoPaquete = 3;
                precioSeleccionado = subPaquetesTiempoPrecios[2];
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }
    public void eligeOtroPaquete(View view){
        Intent i = new Intent(this,SubPaquetesControlador.class);
        Bundle datos1 = getIntent().getExtras();
        i.putExtra("nombreCategoria",nombreCategoria);
        i.putExtra("promocion",promocionActiva);
        i.putExtra("nombresSubPaquetes", datos1.getStringArray("nombresSubPaquetes"));
        i.putExtra("preciosSubPaquetes", datos1.getIntArray("preciosSubPaquetes"));
        startActivity(i);
    }
    public void continuaSubPaqueteTiempoSeleccionado(View view){

        Intent i = new Intent(this, calculaTotalResumen.class);
        i.putExtra("nombreCategoria", nombreCategoria);
        i.putExtra("promocion",promocionActiva);
        i.putExtra("nombreSubPaquete", nombreSubPaquete);
        i.putExtra("precioSubPaquete", precioSeleccionado);
        i.putExtra("tiempoPaquete", tiempoPaquete);
        startActivity(i);
    }
}