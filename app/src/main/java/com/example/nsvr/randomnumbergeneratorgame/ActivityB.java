package com.example.nsvr.randomnumbergeneratorgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import java.util.Random;

public class ActivityB extends AppCompatActivity {
    TextView tempB;
    String randomB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tempB = findViewById(R.id.randomNumB);
        randomB = generateRandom();

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            String value = extras.getString("Random");
            tempB.setText(value);
        }

        findViewById(R.id.buttonB).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ActivityA.class);
                intent.putExtra("Random", randomB);
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
