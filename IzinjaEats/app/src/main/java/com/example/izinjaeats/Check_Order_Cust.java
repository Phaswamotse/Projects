package com.example.izinjaeats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Check_Order_Cust extends AppCompatActivity {

    public static TextView ords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check__order__cust);

        Button check_orders = (Button) findViewById(R.id.View_OrdersBtn);

        ords = (TextView) findViewById(R.id.Orders_Txt11);

        check_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AsyncHTTPPost process = new AsyncHTTPPost();
                process.execute();


            }
        });


    }
}
