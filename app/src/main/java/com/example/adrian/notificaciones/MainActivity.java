package com.example.adrian.notificaciones;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends ActionBarActivity {
    Button boton;
    final int[] colores = new int[4];
    int i;
    Context miContexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        miContexto = this;
        setContentView(R.layout.activity_main);
        Toast toast = Toast.makeText(this,R.string.toast, LENGTH_LONG);
        toast.show();
        cargarColores(colores);
        boton = (Button)findViewById(R.id.button);
        i=0;

       boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boton.setBackgroundColor(getResources().getColor(colores[i]));
                Toast.makeText(miContexto,getResources().getResourceEntryName(colores[i]),Toast.LENGTH_SHORT).show();
                //mostrarToast(i);
                i++;
                if (i==4){
                    i=0;
                };
            }
        });
    }
    private void cargarColores(int[] colores){
       /*
        colores[0]= getResources().getColor(R.color.rojo);
        colores[1]= getResources().getColor(R.color.azul);
        colores[2]= getResources().getColor(R.color.rosa);
        colores[3]= getResources().getColor(R.color.verde);
        */
        colores[0]= getResources().getIdentifier("rojo","color",getPackageName());
        colores[1]= getResources().getIdentifier("azul","color",getPackageName());
        colores[2]= getResources().getIdentifier("rosa","color",getPackageName());
        colores[3]= getResources().getIdentifier("verde","color",getPackageName());
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void mostrarToast(int a){
        switch (a){
            case 0: Toast.makeText(this,R.string.rojo,Toast.LENGTH_SHORT).show();
                break;
            case 1: Toast.makeText(this,R.string.azul,Toast.LENGTH_SHORT).show();
                break;
            case 2: Toast.makeText(this,R.string.rosa,Toast.LENGTH_SHORT).show();
                break;
            case 3: Toast.makeText(this,R.string.verde,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
