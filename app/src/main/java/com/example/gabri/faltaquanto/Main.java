package com.example.gabri.faltaquanto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    TextView tva1, tva2, tvp1, tvp2, tvpesoA1, tvpesoA2, tvpesoP1, tvpesoP2, resultado;
    Float a1, a2, p1, p2, pesoA1, pesoA2, pesoP1, pesoP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        pegarTextView();
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

    public void pegarValores(){
        //try {
            a1 = Float.valueOf(tva1.getText().toString());
            a2 = Float.valueOf(tva2.getText().toString());
            p1 = Float.valueOf(tvp1.getText().toString());
            p2 = Float.valueOf(tvp2.getText().toString());
            pesoA1 = Float.valueOf(tvpesoA1.getText().toString());
            pesoA2 = Float.valueOf(tvpesoA2.getText().toString());
            pesoP1 = Float.valueOf(tvpesoP1.getText().toString());
            pesoP2 = Float.valueOf(tvpesoP2.getText().toString());
        //} catch (Exception ex){
        //    ex.printStackTrace();
       // }
    }


    public void calcularAtual(View view){
        try {
            pegarValores();
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

    public void prever(View view){
        Toast toast = Toast.makeText(getApplicationContext(), "Então.. Isso ainda não está pronto.. Guenta ai (Coming Soon)", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.show();
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
