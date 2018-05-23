package com.example.user.tutandroidmysql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class search extends AppCompatActivity {

    EditText editText;
    DBconnection database;
    TextView searchResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        database=new DBconnection(this);

        searchResult=(TextView)findViewById(R.id.id_search_result);

        editText=(EditText)findViewById(R.id.id_search_username);



    }

    public void search(View view) {

        String username=editText.getText().toString();

        String result=database.searchdata(username,'U');
        searchResult.setText(result);


    }
}
