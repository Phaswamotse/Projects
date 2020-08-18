package com.example.izinjaeats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Update_status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_status);

        Button ready = (Button) findViewById(R.id.ready);
        Button collected = (Button) findViewById(R.id.collected);
        final TextView rama = (TextView) findViewById(R.id.updated_stat);

        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String butter = "Ready";
                rama.setText(""+butter);

            }
        });

        collected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String maza = "Collected";
                rama.setText(""+maza);

            }
        });
    }
}
