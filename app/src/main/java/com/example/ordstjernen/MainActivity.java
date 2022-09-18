package com.example.ordstjernen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tekst, countdown, hintinput;
    Button D_knapp,E_knapp,A_knapp,N_knapp,L_knapp,P_knapp,T_knapp,fasit,hint,sjekk,slett;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tekst =(TextView)findViewById(R.id.textView);
         countdown=(TextView)findViewById(R.id.countdown);
         hintinput =(TextView)findViewById(R.id.hintinput);
         D_knapp =(Button)findViewById(R.id.D);
         E_knapp =(Button)findViewById(R.id.E);
         A_knapp =(Button)findViewById(R.id.A);
         N_knapp =(Button)findViewById(R.id.N);
         L_knapp =(Button)findViewById(R.id.L);
         P_knapp =(Button)findViewById(R.id.P);
         T_knapp =(Button)findViewById(R.id.T);
         fasit = (Button)findViewById(R.id.fasit);
         sjekk=(Button)findViewById(R.id.sjekk);
         slett=(Button)findViewById(R.id.slett);
         hint=(Button)findViewById(R.id.hint);

        D_knapp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                tekst.append(D_knapp.getText().toString());
            }
        });
        E_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(E_knapp.getText().toString());
            }
        });
        A_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(A_knapp.getText().toString());
            }
        });
        N_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(N_knapp.getText().toString());
            }
        });
        L_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(L_knapp.getText().toString());
            }
        });
        P_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(P_knapp.getText().toString());
            }
        });
        T_knapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekst.append(T_knapp.getText().toString());
            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Resources res = getResources();
            String[] array = res.getStringArray(R.array.array);
            String randOrd = array[new Random().nextInt(array.length)];
            randOrd = randOrd.replace("E", "*");
            hintinput.setText(randOrd);
            }
        });

        slett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = tekst.length();
                if(index > 0) {
                    String text = tekst.getText().toString();
                    text = text.substring(0, index - 1);
                    tekst.setText(text);
                }else{
                    tekst.setText("");
                }

            }
        });

        sjekk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                String[] array = res.getStringArray(R.array.array);
                String tekst1 = tekst.getText().toString();
                String nedtelling = countdown.getText().toString();
                int countdown1 = Integer.parseInt(nedtelling);
                for (String s : array) {
                    if(tekst1.equals(s)) {
                        Toast.makeText(MainActivity.this, tekst1 + " er riktig!", Toast.LENGTH_SHORT).show();
                        tekst.setText("");
                        countdown1 = countdown1 -1;
                        nedtelling = String.valueOf(countdown1);
                        countdown.setText(nedtelling);
                        break;

                    }
                    else{
                        Toast.makeText(MainActivity.this, tekst1 +" er feil D:", Toast.LENGTH_SHORT).show();
                        tekst.setText("");

                    }
                }
                hintinput.setText("");
            }
        });
    }


}