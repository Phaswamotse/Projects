package com.example.izinjaeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class register_screen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);



        Button tsena = (Button) findViewById(R.id.reg);

        tsena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ngena = new Intent(register_screen.this, Check_Order_Cust.class);
                startActivity(ngena);
            }
        });


        TextView textview = findViewById(R.id.textv);
        String text = "Already registered? Sign In ";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(register_screen.this, "one", Toast.LENGTH_SHORT);
            }
        };
        ss.setSpan(clickableSpan1, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(ss);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }

    private void validate() {
        Intent intent = new Intent(register_screen.this, HomeActivity.class);
        startActivity(intent);
    }
}
