package com.example.izinjaeats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accept_Update_Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept__update__order);

        final TextView Order_Placed = (TextView) findViewById(R.id.Order_Alert);

        Button to_update = (Button) findViewById(R.id.update_btn);

        to_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent to_update_screen = new Intent(Accept_Update_Order.this, Update_status.class);
                startActivity(to_update_screen);

            }
        });


        /*Timer tShow = new Timer();
        Timer tHide = new Timer();

        AlertDialog.Builder builder =  new AlertDialog.Builder(Accept_Update_Order.this);
        builder.setCancelable(true);
        builder.setTitle("New Incoming Order");
        builder.setMessage("Order ID : 100");

        builder.setPositiveButton("Accept Order", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Order_Placed.setVisibility(View.VISIBLE);

            }
        });

        builder.show();*/
     }
}
