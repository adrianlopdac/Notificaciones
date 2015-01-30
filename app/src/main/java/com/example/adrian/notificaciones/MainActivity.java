package com.example.adrian.notificaciones;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends ActionBarActivity {
    Button boton;
    RelativeLayout miLayout;
    TypedArray misColores;
    int i;
    Context miContexto;
    Toast toast;
    Boolean paletaCompleta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        miContexto = this;
        setContentView(R.layout.activity_main);
        toast = Toast.makeText(this,R.string.toast, LENGTH_LONG);
        toast.show();
        paletaCompleta=false;
        cargarColores();
        boton = (Button)findViewById(R.id.button);
        miLayout = (RelativeLayout)findViewById(R.id.miLayout);
        i=0;


       boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                i = rand.nextInt(misColores.length());

                boton.setBackgroundColor(misColores.getColor(i,-1));
                int idColor=misColores.getResourceId(i,-1);
                String nombreColor=getResources().getResourceEntryName(idColor);

                i = rand.nextInt(misColores.length());
                miLayout.setBackgroundColor(misColores.getColor(i,-1));
                idColor=misColores.getResourceId(i,-1);
                nombreColor=nombreColor +" y "+getResources().getResourceEntryName(idColor);

                if (toast!=null){
                    toast.cancel();
                }
                toast = Toast.makeText(miContexto,nombreColor,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    private void cargarColores(){
        if (paletaCompleta==true){
        misColores = getResources().obtainTypedArray(R.array.colors);}
        else{
            misColores = getResources().obtainTypedArray(R.array.colors2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            paletaCompleta=!paletaCompleta;
            cargarColores();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
