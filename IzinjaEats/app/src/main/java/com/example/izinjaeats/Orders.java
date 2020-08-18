package com.example.izinjaeats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Orders extends AppCompatActivity {

    public static TextView orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        orders = (TextView) findViewById(R.id.Orders_Txt);

        AsyncHTTPPost process = new AsyncHTTPPost();
        process.execute();


    }
}
