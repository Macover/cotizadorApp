package com.example.cotizadorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubPaquetesControlador extends Activity {

    TextView tituloCategoria;
    RadioButton opcion1, opcion2, opcion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elige_sub_paquete);

        Bundle datos = getIntent().getExtras();

        String nombreCategoria = datos.getString("nombreCategoria");
        String[] nombresSubPaquetes = datos.getStringArray("nombresSubPaquetes");
        int[] preciosSubPaquetes = datos.getIntArray("preciosSubPaquetes");

        tituloCategoria = (TextView) findViewById(R.id.txtNombreCategoria);

        opcion1 = (RadioButton) findViewById(R.id.rbOpcion1);
        opcion2 = (RadioButton) findViewById(R.id.rbOpcion2);
        opcion3 = (RadioButton) findViewById(R.id.rbOpcion3);

        tituloCategoria.setText(nombreCategoria);
        opcion1.setText(nombresSubPaquetes[0] + " -> $" + preciosSubPaquetes[0]);
        opcion2.setText(nombresSubPaquetes[1] + " -> $" + preciosSubPaquetes[1]);
        opcion3.setText(nombresSubPaquetes[2] + " -> $" + preciosSubPaquetes[2]);
    }
    public void eligeOtraCategoria(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
