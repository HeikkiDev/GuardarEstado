package com.example.primera.recuperardatos;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etxTexto;
    TextView txt; //Etiqueta con string inicial 'New TextView'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        etxTexto = (EditText)findViewById(R.id.etxTexto);
        txt = (TextView)findViewById(R.id.textView);

        if(savedInstanceState == null){
            //
        }
        else {
            // Si es diferente de null es que se ha guardado algo, por tanto reestablecemos valores
            txt.setText(savedInstanceState.getString("miTexto"));
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void GuardaryCerrar(View v){
        // Ponemos en la etiqueta lo que hayamos escrito en el TextView
        txt.setText(etxTexto.getText().toString());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // Esto hace que se guarden algunos datos por defecto, como el contenido del EditText
        outState.putString("miTexto", txt.getText().toString());
    }
}
