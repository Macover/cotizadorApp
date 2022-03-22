package com.example.cotizadorapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class calculaTotalResumen extends Activity {

    TextView tituloPaquetefinal;
    TextView resumenString, resumenStringVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_activity);

        tituloPaquetefinal = (TextView) findViewById(R.id.tituloPaqueteFinal);
        resumenStringVista = (TextView) findViewById(R.id.resumenString);

        Bundle datos = getIntent().getExtras();

        String nombreCategoria = datos.getString("nombreSubPaquete");
        int precioSubPaquete = datos.getInt("precioSubPaquete");



        String resumenString = "Usted ah seleccionado el sub paquete: " + nombreCategoria + "y el precio es: " + precioSubPaquete;

        tituloPaquetefinal.setText(nombreCategoria);
        resumenStringVista.setText(resumenString);

    }
}
