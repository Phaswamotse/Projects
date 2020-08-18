package com.example.izinjaeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cust_Staff_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust__staff__page);

        Button Customer = (Button) findViewById(R.id.Customer);
        Button Rest = (Button) findViewById(R.id.Restaurant);

        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cust_page = new Intent(Cust_Staff_Page.this, WelcomePage.class );
                startActivity(cust_page);
            }
        });

        Rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Rest_page = new Intent(Cust_Staff_Page.this, Restaurant.class );
                startActivity(Rest_page);
            }
        });


    }
}
