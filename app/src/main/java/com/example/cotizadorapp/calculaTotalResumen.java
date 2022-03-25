package com.example.cotizadorapp;

import android.app.Activity;
import android.content.Intent;
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
    boolean promocionActiva;

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
        promocionActiva = datos.getBoolean("promocion");


        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        if(tiempoPaquete==3){
            tiempoExtraCheckBox.setEnabled(true);
        }

        String duracion = "";
        if (tiempoPaquete==1){
            duracion = tiempoPaquete + " mes";
        }else{
            duracion = tiempoPaquete + " meses";
        }

        if(promocionActiva){

            float precioNuevoPaquete = (float) (precioSubPaquete - (precioSubPaquete * 0.25));
            iva = (float) (precioNuevoPaquete * 0.16);
            total = iva + precioNuevoPaquete;

            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "Descuento: 25%"+ "\n"+
                    "Nuevo precio del paquete: $"+precioNuevoPaquete+ "\n"+
                    "Duración: "+duracion+"\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        }else{
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "Duración: "+duracion+"\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        }

        tituloPaquetefinal.setText("¡Paquete listo!");
        resumenStringVista.setText(resumenString);

        Toast.makeText(getApplicationContext(), "¡Cotización realizada satisfactoriamente!", Toast.LENGTH_LONG).show();

    }
    public void onClickCheckBox(View view){

        iva = (float) (precioSubPaquete * 0.16);
        total = precioSubPaquete + iva;

        String duracion = "";



        if(tiempoExtraCheckBox.isChecked() && !promocionActiva){
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
        }else if(tiempoExtraCheckBox.isChecked() && promocionActiva){
            float nuuevoPrecioSubPaquete =  (float) (precioSubPaquete - (precioSubPaquete * 0.25));
            float subTotal = nuuevoPrecioSubPaquete + 150;
            iva = (float) (subTotal* 0.16);
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
                    "Descuento: 25%"+ "\n"+
                    "Duración: "+duracion+"\n"+
                    "Nuevo precio del paquete: $"+nuuevoPrecioSubPaquete+ "\n"+
                    "1 mes extra: $150"+ "\n"+
                    "Sub total: "+subTotal+"\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        }else if(!tiempoExtraCheckBox.isChecked() && promocionActiva){
            float precioNuevoPaquete = (float) (precioSubPaquete - (precioSubPaquete * 0.25));
            iva = (float) (precioNuevoPaquete * 0.16);
            total = iva + precioNuevoPaquete;
            tiempoPaquete--;
            if (tiempoPaquete==1){
                duracion = tiempoPaquete + " mes";
            }else{
                duracion = tiempoPaquete + " meses";
            }
            resumenString = "Usted ah seleccionado la categoria de: " + nombreCategoria + "\n"+
                    "Nombre del paquete seleccionado: " + nombreSubPaquete+ "\n"+
                    "Precio del paquete: $"+precioSubPaquete+ "\n"+
                    "Descuento: 25%"+ "\n"+
                    "Nuevo precio del paquete: $"+precioNuevoPaquete+ "\n"+
                    "Duración: "+duracion+"\n"+
                    "IVA: $"+iva+ "\n"+
                    "Total: $"+total;
        } else{
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
    public void otraCotizacion(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void finalizarApp(View view){
        finishAffinity();
    }

}
