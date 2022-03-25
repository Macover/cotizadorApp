package com.example.cotizadorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubPaquetesControlador extends AppCompatActivity {

    TextView tituloCategoria;
    RadioButton opcion1, opcion2, opcion3;

    String nombreCategoria;
    String[] nombresSubPaquetes;
    int[] preciosSubPaquetes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elige_sub_paquete);

        Bundle datos = getIntent().getExtras();

        nombreCategoria = datos.getString("nombreCategoria");
        nombresSubPaquetes = datos.getStringArray("nombresSubPaquetes");
        preciosSubPaquetes = datos.getIntArray("preciosSubPaquetes");

        tituloCategoria = (TextView) findViewById(R.id.txtNombreCategoria);

        opcion1 = (RadioButton) findViewById(R.id.rbOpcion1);
        opcion2 = (RadioButton) findViewById(R.id.rbOpcion2);
        opcion3 = (RadioButton) findViewById(R.id.rbOpcion3);

        tituloCategoria.setText(nombreCategoria);
        opcion1.setText(nombresSubPaquetes[0] + "$" +preciosSubPaquetes[0]);
        opcion2.setText(nombresSubPaquetes[1] + "$" +preciosSubPaquetes[1]);
        opcion3.setText(nombresSubPaquetes[2] + "$" +preciosSubPaquetes[2]);
    }
    public void eligeOtraCategoria(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void continuaSubPaqueteSeleccionado(View view){

        Intent i = new Intent(this, subPaquetesTiempo.class);
        i.putExtra("nombreCategoria", this.nombreCategoria);

        if(opcion1.isChecked()){
            i.putExtra("nombreSubPaquete", nombresSubPaquetes[0]);
            i.putExtra("precioSubPaquete", preciosSubPaquetes[0]);
        }
        if(opcion2.isChecked()){
            i.putExtra("nombreSubPaquete", nombresSubPaquetes[1]);
            i.putExtra("precioSubPaquete", preciosSubPaquetes[1]);
        }
        if(opcion3.isChecked()){
            i.putExtra("nombreSubPaquete", nombresSubPaquetes[2]);
            i.putExtra("precioSubPaquete", preciosSubPaquetes[2]);
        }
        startActivity(i);
    }
}
