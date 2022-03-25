package com.example.cotizadorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class calculaTotalResumen extends AppCompatActivity {

    TextView tituloPaquetefinal, resumenStringVista;
    CheckBox tiempoExtraCheckBox;
    String resumenString;
    float iva, total;

    String nombreSubPaquete;
    String nombreCategoria;
    float precioSubPaquete;
    int tiempoPaquete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumen_activity);

        tituloPaquetefinal = (TextView) findViewById(R.id.tituloPaqueteFinal);
        resumenStringVista = (TextView) findViewById(R.id.resumenString);
        tiempoExtraCheckBox = (CheckBox) findViewById(R.id.paqueteCkB);

        Bundle datos = getIntent().getExtras();

        nombreCategoria = datos.getString("nombreCategoria");
        nombreSubPaquete = datos.getString("nombreSubPaquete");
        precioSubPaquete = datos.getFloat("precioSubPaquete");
        tiempoPaquete = datos.getInt("tiempoPaquete");


        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        String duracion = "";
        if (tiempoPaquete==1){
            duracion = tiempoPaquete + " mes";
        }else{
            duracion = tiempoPaquete + " meses";
        }

        resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                "Precio del paquete: $"+precioSubPaquete+ "\n"+
                "Duración: "+duracion+"\n"+
                "IVA: $"+iva+ "\n"+
                "Total: $"+total;


        tituloPaquetefinal.setText("¡Paquete listo!");
        resumenStringVista.setText(resumenString);

    }
    public void onClickCheckBox(View view){

        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        String duracion = "";

        if(tiempoExtraCheckBox.isChecked()){
            iva = (float) ((precioSubPaquete + 150)* 0.16);
            total = precioSubPaquete+150 + iva;
            tiempoPaquete++;
            if (tiempoPaquete==1){
                duracion = tiempoPaquete + " mes";
            }else{
                duracion = tiempoPaquete + " meses";
            }
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "Duración: "+duracion+"\n"+
                    "1 mes extra: $150"+ "\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        }else{
            tiempoPaquete--;
            if (tiempoPaquete==1){
                duracion = tiempoPaquete + " mes";
            }else{
                duracion = tiempoPaquete + " meses";
            }
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "Duración: "+duracion+"\n"+
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
