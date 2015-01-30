package com.example.adrian.notificaciones;

import android.content.Context;
import android.content.res.TypedArray;
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
    TypedArray misColores;
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

                boton.setBackgroundColor(misColores.getColor(i,-1));
                int idColor=misColores.getResourceId(i,-1);
                String nombreColor=getResources().getResourceEntryName(idColor);
                Toast.makeText(miContexto,nombreColor,Toast.LENGTH_SHORT).show();
                if(i<misColores.length()-1){
                    i++;
                }else{
                    i=0;
                }
            }
        });
    }
    private void cargarColores(int[] colores){
        misColores = getResources().obtainTypedArray(R.array.colors);
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


}
