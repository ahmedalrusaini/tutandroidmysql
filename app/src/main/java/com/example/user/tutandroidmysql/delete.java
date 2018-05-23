package com.example.user.tutandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class delete extends AppCompatActivity {

    private EditText txtdelete;

    DBconnection database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        txtdelete=(EditText)findViewById(R.id.id_delete);

        database=new DBconnection(this);
    }

    public void delete(View view) {
        String deleteString = txtdelete.getText().toString();

        database.deletename(deleteString);

    }
}
