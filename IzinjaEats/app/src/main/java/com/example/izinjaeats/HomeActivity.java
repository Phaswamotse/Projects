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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private EditText email, password ;
    private Button btn_login ;
    private  static  String URL_LOGIN = "http://lamp.ms.wits.ac.za/~s1836213/login.php" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.editText2);
        btn_login = (Button) findViewById(R.id.Log_IN);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPassword = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPassword.isEmpty()) {
                    Login(mEmail,mPassword);
                } else {
                    email.setError("Please insert email");
                    password.setError("Please insert password");
                }
            }
        });

        Button tsena = (Button) findViewById(R.id.Log_IN);

        tsena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ngena = new Intent(HomeActivity.this, Check_Order_Cust.class);
                startActivity(ngena);
            }
        });


        TextView textview = findViewById(R.id.textview);
        String text = " Not yet registered? register here";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(HomeActivity.this, "one", Toast.LENGTH_SHORT);
            }
        };
        ss.setSpan(clickableSpan1, 29, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(ss);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }


    private void Login(final String email ,final String password) {
        btn_login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response) ;
                            String success =jsonObject.getString("success") ;
                            JSONArray jsonArray = jsonObject.getJSONArray("login") ;

                            if (success.equals("1")){
                                for (int i=0 ; i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i) ;

                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();

                                    Toast.makeText(HomeActivity.this,"Success Login. \nYour name : "+name+" \nYour email : "+email,Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(HomeActivity.this,"Error"+e.toString(),Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(HomeActivity.this,"Error"+error.toString(),Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String ,String>params = new HashMap<>() ;
                params.put("email",email) ;
                params.put("password",password) ;
                return params ;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this) ;
        requestQueue.add(stringRequest) ;


    }







    private void validate() {
        Intent intent = new Intent(HomeActivity.this, register_screen.class);
        startActivity(intent);
    }
}

