package com.akshit.webua;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.content.SharedPreferences;
import java.util.Random;

public class MainActivity extends Activity {

    String[] randomWords = {
        "PixelXtreme", "PhantomMode", "DevGhost", "SnapUltra"
    };

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        EditText edit = findViewById(R.id.editTextUA);
        Button btnSet = findViewById(R.id.buttonSet);
        Button btnRand = findViewById(R.id.buttonRandom);
        TextView txt = findViewById(R.id.textViewCurrent);

        SharedPreferences prefs = getSharedPreferences("UA", MODE_PRIVATE);
        txt.setText("Current UA: " + prefs.getString("ua", "Not Set"));

        btnSet.setOnClickListener(v -> {
            String ua = edit.getText().toString().trim();
            prefs.edit().putString("ua", ua).apply();
            txt.setText("Current UA: " + ua);
        });

        btnRand.setOnClickListener(v -> {
            String word = randomWords[new Random().nextInt(randomWords.length)];
            String ua = "Mozilla/5.0 (Linux; Android 13; " + word + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36";
            prefs.edit().putString("ua", ua).apply();
            txt.setText("Current UA: " + ua);
        });
    }
}