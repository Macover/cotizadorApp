package com.example.cotizadorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    String nombreCategoria = "";
    String[] nombreSubPaquetes = new String[3];
    int[] preciosSubPaquetes = new int[3];
    boolean promocionActiva = false;

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

        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        System.out.println(currentDate);

        if(currentDate.contains("26-03-2022")){
            promocionActiva = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Parece que hoy es 26 de marzo y por ello, todos los paquetes estan al 25% de descuento.")
                    .setTitle("¡Promoción solo hoy!");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.out.println(dialogInterface);
                    System.out.println(i);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }





    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch (pos){
            case 0:
                this.nombreCategoria = "Cloud hosting";

                this.nombreSubPaquetes[0] = "Cloud Básico";
                this.nombreSubPaquetes[1] = "Cloud Profesional";
                this.nombreSubPaquetes[2] = "Cloud Empresa";

                this.preciosSubPaquetes[0] = 200;
                this.preciosSubPaquetes[1] = 215;
                this.preciosSubPaquetes[2] = 300;

                break;
            case 1:
                this.nombreCategoria = "VPS Hosting";

                this.nombreSubPaquetes[0] = "VPS Ligero";
                this.nombreSubPaquetes[1] = "VPS Normal";
                this.nombreSubPaquetes[2] = "VPS Pro";

                this.preciosSubPaquetes[0] = 150;
                this.preciosSubPaquetes[1] = 200;
                this.preciosSubPaquetes[2] = 225;

                break;
            case 2:
                this.nombreCategoria = "WordPress Hosting";

                this.nombreSubPaquetes[0] = "W Estandar";
                this.nombreSubPaquetes[1] = "W Negocios";
                this.nombreSubPaquetes[2] = "W Profesional";

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
                this.nombreSubPaquetes[0] = "Email básico";
                this.nombreSubPaquetes[1] = "Email de negocios";
                this.nombreSubPaquetes[2] = "Email de empresa";

                this.preciosSubPaquetes[0] = 300;
                this.preciosSubPaquetes[1] = 450;
                this.preciosSubPaquetes[2] = 700;
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
        i.putExtra("promocion", promocionActiva);
        finish();
        startActivity(i);
    }
    public void finalizarApp(View vista){
        finishAffinity();
    }
}



