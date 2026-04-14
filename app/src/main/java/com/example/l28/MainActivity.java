package com.example.l28;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView MultiautoComplete;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultiautoComplete = findViewById(R.id.MultiautoComplete);
        btnConfirm = findViewById(R.id.btnConfirm);

        // 1. Pobranie listy podpowiedzi z zasobów strings.xml
        String[] countries = {
                "Polska",
                "Niemcy",
                "Czechy",
                "Słowacja",
                "Francja",
                "Hiszpania",
                "Włochy",
                "Wielka Brytania"
        };

        // 2. Stworzenie ArrayAdapter
        // simple_dropdown_item_1line to layout zaprojektowany specjalnie
        // pod listy rozwijane AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, countries);

        // 3. Podłączenie adaptera do AutoCompleteTextView
        MultiautoComplete.setAdapter(adapter);
// CommaTokenizer sprawia, że po przecinku podpowiedzi pojawiają się od nowa
        MultiautoComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        // Obsługa przycisku do potwierdzenia wyboru
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCountry = MultiautoComplete.getText().toString();
                Toast.makeText(MainActivity.this,
                        "Wybrano: " + selectedCountry,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
