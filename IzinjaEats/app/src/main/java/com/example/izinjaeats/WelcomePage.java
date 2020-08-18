package com.example.izinjaeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {

    Button loginbtn;
    Button signUpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        loginbtn = (Button) findViewById(R.id.LoginBtn);
        signUpBtn = (Button) findViewById(R.id.SignUpBtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent loginActivity = new Intent(WelcomePage.this, HomeActivity.class);
                startActivity(loginActivity);

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signUpActivity = new Intent(WelcomePage.this, register_screen.class);
                startActivity(signUpActivity);
            }
        });
    }
}
