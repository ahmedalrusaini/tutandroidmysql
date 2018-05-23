package com.example.user.tutandroidmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLiteProcesses extends AppCompatActivity {

    private EditText Fullname;
    private EditText Username;
    private EditText Password;
    private DBconnection database;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_processes);

        database=new DBconnection(this);

        Fullname = (EditText)findViewById(R.id.id_name);
        Username = (EditText)findViewById(R.id.id_username);
        Password = (EditText)findViewById(R.id.id_password);

        result = (TextView)findViewById(R.id.id_result);
    }


    public void save(View view){
        String full_name=Fullname.getText().toString();
        String user_name=Username.getText().toString();
        String pass_word=Password.getText().toString();

        long id= database.dataInsert(full_name,user_name,pass_word);
        if (id<0){
            Toast.makeText(this,"Error not Inserted",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"successfully Inserted.",Toast.LENGTH_LONG).show();
        }

    }


    public void view(View view){
        String data=database.viewData();
        result.setText(data);
    }

    public void update(View view) {
        startActivity(new Intent(this,update.class));
    }

    public void delete(View view) {
        startActivity(new Intent(this,delete.class));
    }

    public void search(View view) {
        startActivity(new Intent(this,search.class));
    }
}
