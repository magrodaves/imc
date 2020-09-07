package com.facu.mmc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText edtAltura;
    private EditText edtPeso;
    private Button btnCalcular;
    private TextView txvImc;
    private TextView txvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        btnCalcular = (Button) findViewById(R.id.bntCalcular);
        txvImc = (TextView) findViewById(R.id.txvImc);
        txvResultado = (TextView) findViewById(R.id.txvRasultado);

    }

    public void calcular (View view) {

        String alturaStr = edtAltura.getText().toString();
        String pesoStr = edtPeso.getText().toString();

        Double altura = Double.valueOf(alturaStr);
        Double peso = Double.valueOf(pesoStr);

        Double imc = peso / (altura * altura);
        txvImc.setText(imc.toString());

        if(imc < 18.5){
            txvResultado.setText("Abaixo do peso!");
        }
        if(imc >= 18.6 && imc <= 24.9){
            txvResultado.setText("Saudável");
        }
        if(imc >= 25.0 && imc <= 29.9){
            txvResultado.setText("Peso em excesso!");
        }
        if(imc >= 30){
            txvResultado.setText("Obesidade!");
        }
    }
}