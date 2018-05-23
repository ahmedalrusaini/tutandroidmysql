package com.example.user.tutandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

public class UpdateMysql2 extends AppCompatActivity {

    //static EditText ID,USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mysql2);

        //ID = (EditText)findViewById(R.id.id_mysql_update_txt_id);
        //USERNAME = (EditText)findViewById(R.id.id_mysql_update_txt_username);


    }

    public void updatebtn(View view) {


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.1.22/api/v1/updateUser.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JSONResponse = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),JSONResponse.getString("msg"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                super.getParams();
                Map<String, String> Params=new HashMap<>();
                Params.put("id",( ( (EditText)findViewById(R.id.id_mysql_update_txt_id) ) ).getText().toString().trim() );
                Params.put("username",( ( (EditText)findViewById(R.id.id_mysql_update_txt_username) ) ).getText().toString().trim() );
                return Params;
            }
        };

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }



}
