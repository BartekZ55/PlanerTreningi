package com.example.planertreningow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ImageView imgCwiczenie;
    private TextView txtNazwaCwiczenia, txtLicznikSerii, txtLacznaLiczbaSerii;
    private Button btnLosuj, btnMinus, btnPlus, btnNastepne, btnReset;

    private int licznikAktualnegoCwiczenia = 0;
    private int lacznaLiczbaSerii = 0;
    private Random random = new Random();

    private final String[] nazwyCwiczen = {
            "Losuj ćwiczenie",
            "Przysiad",
            "Pompki",
            "Plank",
            "Wykroki",
            "Burpees",
            "Podciąganie"
    };

    private final int[] obrazyCwiczen = {
            R.drawable.cwiczenie0,
            R.drawable.cwiczenie1,
            R.drawable.cwiczenie2,
            R.drawable.cwiczenie3,
            R.drawable.cwiczenie4,
            R.drawable.cwiczenie5,
            R.drawable.cwiczenie6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCwiczenie = findViewById(R.id.imgCwiczenie);
        txtNazwaCwiczenia = findViewById(R.id.txtNazwaCwiczenia);
        txtLicznikSerii = findViewById(R.id.txtLicznikSerii);
        txtLacznaLiczbaSerii = findViewById(R.id.txtLacznaLiczbaSerii);

        btnLosuj = findViewById(R.id.btnLosuj);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnNastepne = findViewById(R.id.btnNastepne);
        btnReset = findViewById(R.id.btnReset);

        btnLosuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losujNoweCwiczenie();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licznikAktualnegoCwiczenia++;
                txtLicznikSerii.setText(String.valueOf(licznikAktualnegoCwiczenia));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (licznikAktualnegoCwiczenia > 0) {
                    licznikAktualnegoCwiczenia--;
                    txtLicznikSerii.setText(String.valueOf(licznikAktualnegoCwiczenia));
                }
            }
        });

        btnNastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lacznaLiczbaSerii += licznikAktualnegoCwiczenia;
                txtLacznaLiczbaSerii.setText("Łączna liczba serii: " + lacznaLiczbaSerii);
                losujNoweCwiczenie();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetujAplikacje();
            }
        });
    }

    private void losujNoweCwiczenie() {
        int wylosowana = random.nextInt(6) + 1;
        imgCwiczenie.setImageResource(obrazyCwiczen[wylosowana]);
        txtNazwaCwiczenia.setText(nazwyCwiczen[wylosowana]);
        licznikAktualnegoCwiczenia = 0;
        txtLicznikSerii.setText(String.valueOf(licznikAktualnegoCwiczenia));
    }

    private void resetujAplikacje() {
        licznikAktualnegoCwiczenia = 0;
        lacznaLiczbaSerii = 0;
        txtLicznikSerii.setText("0");
        txtLacznaLiczbaSerii.setText("Łączna liczba serii: 0");
        imgCwiczenie.setImageResource(obrazyCwiczen[0]);
        txtNazwaCwiczenia.setText(nazwyCwiczen[0]);
    }
}