package com.example.cotizadorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class calculaTotalResumen extends Activity {

    TextView tituloPaquetefinal, resumenStringVista;
    CheckBox tiempoExtraCheckBox;
    String resumenString;
    float iva, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_activity);

        tituloPaquetefinal = (TextView) findViewById(R.id.tituloPaqueteFinal);
        resumenStringVista = (TextView) findViewById(R.id.resumenString);
        tiempoExtraCheckBox = (CheckBox) findViewById(R.id.paqueteCkB);

        Bundle datos = getIntent().getExtras();

        String nombreCategoria = datos.getString("nombreCategoria");
        String nombreSubCategoria = datos.getString("nombreSubPaquete");
        String tiempoPaquete = datos.getString("tiempoPaquete");
        int precioSubPaquete = datos.getInt("precioSubPaquete");

        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                "Nombre del paquete seleccionado: " + nombreSubCategoria+ "\n"+
                "Precio del paquete: $"+precioSubPaquete+ "\n"+
                "Duración: "+tiempoPaquete+ "\n"+
                "IVA: $"+iva+ "\n"+
                "Total: $"+total;


        tituloPaquetefinal.setText("¡Paquete listo!");
        resumenStringVista.setText(resumenString);

    }
    public void onClickCheckBox(View view){

        Bundle datos = getIntent().getExtras();
        String nombreCategoria = datos.getString("nombreCategoria");
        String nombreSubCategoria = datos.getString("nombreSubPaquete");
        int precioSubPaquete = datos.getInt("precioSubPaquete");

        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        if(tiempoExtraCheckBox.isChecked()){
            total+= 150;
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubCategoria+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "IVA: $"+iva+ "\n"+
                    "Extra: $150"+ "\n"+
                    "Total: $"+total;
        }else{
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubCategoria+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        }
        //finish afinaty
        resumenStringVista.setText(resumenString);


    }
    public void msjAceptado(View view){

        Button btnVistaPrincipal;

        //agregar boton de ir a la principal.

        Toast.makeText(getApplicationContext(), "El paquete fue seleccionado correctamente", Toast.LENGTH_SHORT).show();
    }
}
