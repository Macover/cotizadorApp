package com.example.cotizadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String nombreCategoria = "";
    String[] nombreSubPaquetes = new String[3];
    int[] preciosSubPaquetes = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinnerCategoriasVista);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (pos){
            case 0:
                this.nombreCategoria = "Cloud hosting";

                this.nombreSubPaquetes[0] = "Cloud startup";
                this.nombreSubPaquetes[1] = "Cloud Profesional";
                this.nombreSubPaquetes[2] = "Cloud Empresa";

                this.preciosSubPaquetes[0] = 200;
                this.preciosSubPaquetes[1] = 215;
                this.preciosSubPaquetes[2] = 300;

                break;
            case 1:
                this.nombreCategoria = "VPS Hosting";

                this.nombreSubPaquetes[0] = "VPS 1";
                this.nombreSubPaquetes[1] = "VPS 2";
                this.nombreSubPaquetes[2] = "VPS 3";

                this.preciosSubPaquetes[0] = 150;
                this.preciosSubPaquetes[1] = 200;
                this.preciosSubPaquetes[2] = 225;

                break;
            case 2:
                this.nombreCategoria = "WordPress Hosting";

                this.nombreSubPaquetes[0] = "W Starter";
                this.nombreSubPaquetes[1] = "W Bussines";
                this.nombreSubPaquetes[2] = "W Pro";

                this.preciosSubPaquetes[0] = 150;
                this.preciosSubPaquetes[1] = 175;
                this.preciosSubPaquetes[2] = 200;
                break;
            case 3:
                this.nombreCategoria = "Dominio";
                this.nombreSubPaquetes[0] = ".com";
                this.nombreSubPaquetes[1] = ".net";
                this.nombreSubPaquetes[2] = ".info";

                this.preciosSubPaquetes[0] = 315;
                this.preciosSubPaquetes[1] = 250;
                this.preciosSubPaquetes[2] = 100;
                break;
            case 4:
                this.nombreCategoria = "Email";
                this.nombreSubPaquetes[0] = "Email de empresa";
                this.nombreSubPaquetes[1] = "Email de negocios";
                this.nombreSubPaquetes[2] = "no definido";

                this.preciosSubPaquetes[0] = 700;
                this.preciosSubPaquetes[1] = 450;
                this.preciosSubPaquetes[2] = 0;
                break;
            case 5:
                this.nombreCategoria = "Servidor dedicado";
                this.nombreSubPaquetes[0] = "Liviano";
                this.nombreSubPaquetes[1] = "Normal";
                this.nombreSubPaquetes[2] = "Rendimiento";

                this.preciosSubPaquetes[0] = 1500;
                this.preciosSubPaquetes[1] = 1800;
                this.preciosSubPaquetes[2] = 2200;
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void pasaValoresSigVista(View view){
        Intent i = new Intent(this,SubPaquetesControlador.class);
        i.putExtra("nombreCategoria",nombreCategoria);
        i.putExtra("nombresSubPaquetes", nombreSubPaquetes);
        i.putExtra("preciosSubPaquetes", preciosSubPaquetes);
        startActivity(i);
    }
    public void finalizarApp(View vista){
        finishAffinity();
    }
}



