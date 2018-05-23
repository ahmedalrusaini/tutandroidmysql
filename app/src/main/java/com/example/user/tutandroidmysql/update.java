package com.example.user.tutandroidmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class update extends AppCompatActivity {

    private EditText txtold;
    private EditText txtnew;

    private DBconnection database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtold = (EditText)findViewById(R.id.id_update_old);
        txtnew = (EditText)findViewById(R.id.id_update_new);

        database=new DBconnection(this);

    }

    public void update(View view) {
        String oldString = txtold.getText().toString();
        String newString = txtnew.getText().toString();

        database.updatename(oldString,newString);

    }
}
