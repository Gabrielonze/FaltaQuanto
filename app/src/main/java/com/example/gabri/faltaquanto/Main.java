package com.example.gabri.faltaquanto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main extends AppCompatActivity {

    TextView tva1, tva2, tvp1, tvp2, tvpesoA1, tvpesoA2, tvpesoP1, tvpesoP2, resultado;
    Float a1, a2, p1, p2, pesoA1, pesoA2, pesoP1, pesoP2, mediaAzul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pegarTextView();
        mediaAzul = Float.valueOf(5);
    }

    public void pegarTextView(){
        tva1 = (TextView) findViewById(R.id.a1);
        tva2 = (TextView) findViewById(R.id.a2);
        tvp1 = (TextView) findViewById(R.id.p1);
        tvp2 = (TextView) findViewById(R.id.p2);
        tvpesoA1 = (TextView) findViewById(R.id.pesoA1);
        tvpesoA2 = (TextView) findViewById(R.id.pesoA2);
        tvpesoP1 = (TextView) findViewById(R.id.pesoP1);
        tvpesoP2 = (TextView) findViewById(R.id.pesoP2);
        resultado = (TextView) findViewById(R.id.resultado);
    }

    public void pegarValoresOld(){
        a1 = Float.valueOf(tva1.getText().toString());
        a2 = Float.valueOf(tva2.getText().toString());
        p1 = Float.valueOf(tvp1.getText().toString());
        p2 = Float.valueOf(tvp2.getText().toString());
        pesoA1 = Float.valueOf(tvpesoA1.getText().toString());
        pesoA2 = Float.valueOf(tvpesoA2.getText().toString());
        pesoP1 = Float.valueOf(tvpesoP1.getText().toString());
        pesoP2 = Float.valueOf(tvpesoP2.getText().toString());
    }


    public float pegarValor(TextView in){
        float ret;
        if(in.getText().toString().equals("")){
            ret = 0F;
        } else {
            ret = Float.valueOf(in.getText().toString());
        }
        return ret;
    }

    public void pegarValores(){
        a1 = pegarValor(tva1);
        a2 = pegarValor(tva2);
        p1 = pegarValor(tvp1);
        p2 = pegarValor(tvp2);
        pesoA1 = pegarValor(tvpesoA1);
        pesoA2 = pegarValor(tvpesoA2);
        pesoP1 = pegarValor(tvpesoP1);
        pesoP2 = pegarValor(tvpesoP2);
    }

    public void calcularAtual(View view){
        try {
            pegarValoresOld();
            float n1 = ((a1 * pesoA1) + (p1 * pesoP1)) / (pesoA1 + pesoP1);
            float n2 = ((a2 * pesoA2) + (p2 * pesoP2)) / (pesoA2 + pesoP2);
            float mf = (n1 + n2) / 2;

            String out = "N1: " + n1 + "\nN2: " + n2 + "\nMF: " + mf;
            resultado.setText(out);
        } catch (Exception ex){
            Toast toast = Toast.makeText(getApplicationContext(), "Seu burro, complete tudo antes de calcular.. ou preveja, né? (Coming Soon)", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();
        }
    }

    public float calcularMF(Float p2Nova){
        pegarValores();
        float n1 = ((a1 * pesoA1) + (p1 * pesoP1)) / (pesoA1 + pesoP1);
        float n2 = ((a2 * pesoA2) + (p2Nova * pesoP2)) / (pesoA2 + pesoP2);
        float mf = (n1 + n2) / 2;
        return mf;
    }

    public void prever(View view){
        String out = "Error: Fudeu";
        try {
            if(calcularMF(0F) >= 5F){
                out = "Smart Guy.. Passou sem P2! Congrats! MF temp:"+calcularMF(0F);
            } else {
                out = "P2 - Media";
                /*for(float i = 0; i < 10; i += 0.1F) {
                    float np2, mf;
                    BigDecimal bd = new BigDecimal(i).setScale(2, RoundingMode.HALF_EVEN);
                    np2 = bd.floatValue();
                    bd = new BigDecimal(calcularMF(i)).setScale(2, RoundingMode.HALF_EVEN);
                    mf = bd.floatValue();
                    if(mf == 5F){
                        out += "\n" + np2 + " - " + mf;
                    }

                }*/
                out = "precisa tirar "+((5 *(pesoA2+pesoP2) - a1*pesoA1)/pesoP2)+" na P2 para passar com 5.";
            }

            resultado.setText(out);
            resultado.setMovementMethod(new ScrollingMovementMethod());

        } catch (Exception ex){
            Toast toast2 = Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG);
            toast2.setGravity(Gravity.BOTTOM, 0, 0);
            toast2.show();
        }

    }

    public void limpar(View view){
        tva1.setText("");
        tva2.setText("");
        tvp1.setText("");
        tvp2.setText("");
        tvpesoA1.setText("");
        tvpesoA2.setText("");
        tvpesoP1.setText("");
        tvpesoP2.setText("");
        resultado.setText("Obrigado, tinha muitos numeros ai :)");
    }
}
