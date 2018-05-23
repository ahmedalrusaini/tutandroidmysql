package com.example.user.tutandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

public class insertMysql extends AppCompatActivity {
/*
    privatenewUser;
    private EditText pass;
    private EditText newemail;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_mysql);


        final EditText newUser=(EditText)findViewById(R.id.id_mysql_insert_newuser);

        final EditText pass=(EditText)findViewById(R.id.id_mysql_insert_password);

        final EditText newemail=(EditText)findViewById(R.id.id_mysql_insert_email);

        final Button btn =(Button)findViewById(R.id.id_mysql_insert_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://192.168.1.20/api/v1/registerUser.php";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject JSONResponse=new JSONObject(response);
                                    Toast.makeText(getApplicationContext(),JSONResponse.getString("message"),Toast.LENGTH_LONG).show();
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
                        Map<String,String> Params=new HashMap<>();

                        String newUserString=newUser.getText().toString().trim();
                        Params.put("username",newUserString);

                        String passString=pass.getText().toString().trim();
                        Params.put("password",passString);

                        String emailString=newemail.getText().toString().trim();
                        Params.put("email",emailString);

                        return Params;
                    }
                };

                // Add the request to the RequestQueue.
                queue.add(stringRequest);



            }
        });


    }



}
