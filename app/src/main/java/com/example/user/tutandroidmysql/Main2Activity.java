package com.example.user.tutandroidmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ID=(TextView)findViewById(R.id.id_id);
    }

    public void viewallinfo(View view){
        //startActivity(     (  new Intent(this,ViewAllInfo.class)   ).putExtra("key1",ID.getText().toString())    );
        String IDValue = ID.getText().toString();
        Intent intent=new Intent(this,ViewAllInfo.class);
        intent.putExtra("key1", IDValue );
        startActivity(intent);
    }
}
