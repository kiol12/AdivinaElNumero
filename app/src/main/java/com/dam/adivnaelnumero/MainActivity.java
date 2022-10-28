package com.dam.adivnaelnumero;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int counter = 5;
  //  boolean acierto = false;
    int randomNumber;

    RelativeLayout layout;

    TextView numIntentos;
    TextView textoPista;

    EditText input;
    Button btnComprobar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();

        randomNumber = randomGenerator.nextInt(100);

        numIntentos = findViewById(R.id.textCantidad);
        textoPista = findViewById(R.id.textPista);
        input = findViewById(R.id.numero);
        btnComprobar = findViewById(R.id.botonComparacion);
        layout = findViewById(R.id.relLayout);



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int intento = Integer.parseInt(input.getText().toString().trim());

            if(intento  == randomNumber){
                btnComprobar.setText(R.string.termAcierto);
                layout.setBackgroundColor(getColor(R.color.green));
            }
            if(intento != randomNumber){
                counter--;
                numIntentos.setText(Integer.toString(counter));

                if(intento > randomNumber){
                    textoPista.setText(R.string.NumeroMayor);
                }
                else if(intento < randomNumber){
                    textoPista.setText(R.string.NumeroMenor);
                }
            }
            if(counter == 0){
                btnComprobar.setText(R.string.termAcierto);
                layout.setBackgroundColor(getColor(R.color.red));
                btnComprobar.setEnabled(false);
                textoPista.setText(Integer.toString(randomNumber));
            }

            }
        };

        btnComprobar.setOnClickListener(listener);
    }

}