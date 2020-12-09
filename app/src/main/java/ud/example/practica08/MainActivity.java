package ud.example.practica08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import Clases.WebServices;

public class MainActivity extends AppCompatActivity {
    private Button miboton;
    private TextView salida, valoreuro;
    private EditText entrada;
    private RadioButton cambioP;
    private String editText;
    private String displayText;
    private String displayEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambioP = findViewById(R.id.radioButton);
        cambioP.setChecked(true);
        entrada = findViewById(R.id.editTextNumberDecimal);
        salida = findViewById(R.id.textView3);
        miboton = findViewById(R.id.button);
        miboton.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                if (entrada.getText().length() != 0 && entrada.getText().toString() != "")
                {
                    editText = entrada.getText().toString();
                    CambioEurolWS task = new CambioEurolWS();
                    task.execute();
                    salida.setVisibility(View.VISIBLE);
            }
            }
        });
        //LLamadoInicialWS capini = new LLamadoInicialWS();
       // capini.execute();

    }

    private class LLamadoInicialWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            double temp = WebServices.CapturaEurosWS("getEuro");
            displayEuro = String.valueOf(temp);
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            valoreuro.setText(displayEuro);
        }
        @Override
        protected void onPreExecute(){
            valoreuro.setText("Comenzo");
        }

    }//LLamadoInicialWS

    private class CambioEurolWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... strings) {
            double temp;
            String tmp=null;
            if(cambioP.isChecked()){
                temp = WebServices.CambioEurosWS("Peso2Euro",editText);
                tmp=" Euros";
            }
            else{
                temp = WebServices.CambioEurosWS("Euro2Peso",editText);
                tmp=" Pesos";
            }
            displayText = String.valueOf(temp)+tmp;
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            salida.setText(displayText);
        }
        @Override
        protected void onPreExecute(){
            salida.setText("Comenzo");
        }
    }//CambioEurolWS

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            displayText = WebServices.HolaMundoWS(editText,"hello");
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            salida.setText(displayText);
        }
        @Override
        protected void onPreExecute(){
            //salida.setText("Comenzo");
        }
    }//AsyncCallWS


}