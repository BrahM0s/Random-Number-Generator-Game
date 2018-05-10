package com.example.nsvr.randomnumbergeneratorgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import java.util.Random;

public class ActivityA extends AppCompatActivity {
    TextView tempA;
    String randomA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        tempA = findViewById(R.id.randomNumA);
        randomA = generateRandom();

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            String value = extras.getString("Random");
            tempA.setText(value);
        }

        findViewById(R.id.buttonA).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ActivityB.class);
                intent.putExtra("Random", randomA);
                startActivity(intent);
                finish();
            }
        });
    }

    public String generateRandom(){
        int min=1;
        int max=100;

        Random r = new Random();
        int random = r.nextInt(max - min + 1 ) + min;

        return String.valueOf(random);
    }
}
