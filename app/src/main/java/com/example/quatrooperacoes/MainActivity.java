package com.example.quatrooperacoes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button mult, divi, sub, som;
    TextView resul;
    EditText num1, num2;
    String nume1, nume2;
    double n1, n2, n3;

    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        som = findViewById(R.id.btnSoma);
        sub = findViewById(R.id.btnSub);
        mult = findViewById(R.id.btnMult);
        divi = findViewById(R.id.btnDiv);

        resul = findViewById(R.id.tvwResul);

        num1 = findViewById(R.id.pri_num);
        num2 = findViewById(R.id.seg_num);

        som.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 nume1 = num1.getText().toString().trim();
                 nume2 = num2.getText().toString().trim();

                 if (nume1.isEmpty() || nume2.isEmpty()) {
                     Toast.makeText(MainActivity.this,"Campo Vazio. Preencha-o", Toast.LENGTH_SHORT).show();
                     return;
                }

                 n1 = Double.parseDouble(nume1);
                 n2 = Double.parseDouble(nume2);
                 n3 = n1 + n2;

                 resul.setText("A soma é " + df.format(n3));

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nume1 = num1.getText().toString().trim();
                nume2 = num2.getText().toString().trim();

                if (nume1.isEmpty() || nume2.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Campo Vazio. Preencha-o", Toast.LENGTH_SHORT).show();
                    return;
                }

                n1 = Double.parseDouble(nume1);
                n2 = Double.parseDouble(nume2);
                n3 = n1 - n2;

                resul.setText("A subtração é " + df.format(n3));

            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nume1 = num1.getText().toString().trim();
                nume2 = num2.getText().toString().trim();

                if (nume1.isEmpty() || nume2.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Campo Vazio. Preencha-o", Toast.LENGTH_SHORT).show();
                    return;
                }

                n1 = Double.parseDouble(nume1);
                n2 = Double.parseDouble(nume2);
                n3 = n1 * n2;

                resul.setText("A Multiplicação é " + df.format(n3));
            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nume1 = num1.getText().toString().trim();
                nume2 = num2.getText().toString().trim();

                if (nume1.isEmpty() || nume2.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Campo Vazio. Preencha-o", Toast.LENGTH_SHORT).show();
                    return;
                }

                n1 = Double.parseDouble(nume1);
                n2 = Double.parseDouble(nume2);
                n3 = n1 / n2;

                if (n2 == 0){
                    Toast.makeText(MainActivity.this,"Não divide por Zero", Toast.LENGTH_SHORT).show();

                } else {
                    resul.setText("A Divisão é " + df.format(n3));
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}