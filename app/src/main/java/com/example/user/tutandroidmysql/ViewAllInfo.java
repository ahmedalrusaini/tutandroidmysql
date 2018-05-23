package com.example.user.tutandroidmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewAllInfo extends AppCompatActivity {

    int id[]={1003,1004,1005};
    String name[]={"socrate","plato","aristote"};

    TextView txtID;
    TextView txtNAME;


    int ID=0;

    String newName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_info);

        //String IDString = (String) getIntent().getExtras().get("key1");
        String IDString = getIntent().getExtras().getString("key1");

        ID=Integer.parseInt( IDString );

        txtID=(TextView)findViewById(R.id.id_txtid);
        txtNAME=(TextView)findViewById(R.id.id_txtname);

        for(int i=0;i<3;i++){
            if (ID == id[i]){
                newName=name[i];
            }
        }

        txtID.setText(IDString);
        txtNAME.setText(newName);

    }
}
