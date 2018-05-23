package com.example.user.tutandroidmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MySQLProcesses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sqlprocesses);

        final TextView mTextView = (TextView) findViewById(R.id.id_txt);
// ...

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.100.16/API/json.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JSONResponse=new JSONObject(response);
                            mTextView.setText(  JSONResponse.getString("NAME")+"\n"
                                                +JSONResponse.getString("PHONE")+"\n"
                                                +JSONResponse.getString("AGE")+"\n");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> Params=new HashMap<>();
                Params.put("submit","isSub");
                return Params;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    public void newuser(View view) {
        startActivity(new Intent(this,insertMysql.class));
    }

    public void deleteuser(View view) {
        startActivity(new Intent(this,deleteMysql.class));
    }

    public void updateuser(View view) {
        startActivity(new Intent(this,UpdateMysql2.class));
    }

    public void selectuser(View view) {
        startActivity(new Intent(this,selectMysql.class));
    }
}
