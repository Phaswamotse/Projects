package com.example.izinjaeats;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 1810589 on 2019/05/10.
 */
public class AsyncHTTPPost extends AsyncTask<Void,Void,Void> {

    String results = "";
    String resultsParsed = "";
    String singleParsed = "";

    @Override

    protected Void doInBackground(Void... voids) {

        try {

            String website = "http://lamp.ms.wits.ac.za/~s1810589/cars.php";

            URL url = new URL(website);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            while (line!=null){

                line = bufferedReader.readLine();
                if(line==null){

                    break;
                }
                else {
                    results = results + line;
                }
            }

            JSONArray JA = new JSONArray(results);

            for (int i = 0; i < JA.length();i++){

                JSONObject JObj = (JSONObject) JA.get(i);

                singleParsed = "COURSE CODE : " + JObj.get("COURSE_CODE") + "\n" +
                        "STUDENT NUMBER : " + JObj.get("STUDENT_NO") + "\n" +
                        "REGISTRATION NUMBER : " + JObj.get("REGISTRATION_NO") + "\n" +
                        "REGISTRATION DATE : " + JObj.get("REGISTRATION_DATE") + "\n" + "\n";


                resultsParsed = resultsParsed + singleParsed;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override

    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        Check_Order_Cust.ords.setText(this.resultsParsed);
    }
}
