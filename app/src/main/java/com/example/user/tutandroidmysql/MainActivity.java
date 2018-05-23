package com.example.user.tutandroidmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    TextView txt3;

    Button plus;
    EditText edit1;
    EditText edit2;

    Switch aSwitch;

    Button btnconcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(TextView) findViewById(R.id.id_txt1);
        txt2=(TextView) findViewById(R.id.id_txt2);
        txt3=(TextView) findViewById(R.id.id_txt3);

        edit1 = (EditText) findViewById(R.id.id_edit1);
        edit2 = (EditText) findViewById(R.id.id_edit2);
        plus = (Button) findViewById(R.id.id_plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setText(    String.valueOf(   Integer.parseInt( edit1.getText().toString() ) + Integer.parseInt( edit2.getText().toString() )   )  );
            }
        });

        aSwitch=(Switch)findViewById(R.id.id_swich);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean Checked) {
                if (Checked){
                    txt2.setText("Ahmed");
                }else {
                    txt2.setText("ALRUSAINI");
                }
            }
        });


        btnconcat = (Button) findViewById(R.id.id_btn_concat);
    }

    public void concat(View view){
        String str1 = txt1.getText().toString();
        String str2 = txt2.getText().toString();

        //String str3 = str1.concat(str2);
        String str3 = str1+" "+str2;

        txt3.setText(str3);

    }

    public void tglchange(View view){
        boolean Checked = ((ToggleButton)view).isChecked();
        if (Checked){
            txt1.setText("Hello world!");
        }else {
            txt1.setText("Java");
        }
    }

    public void radchange(View view){
        boolean Checked = ((RadioButton)view).isChecked();
        if (Checked){
            if (view.getId() == R.id.id_radio1){
                btnconcat.setVisibility(view.VISIBLE);
            }
            if (view.getId() == R.id.id_radio2){
                btnconcat.setVisibility(view.GONE);
            }
        }
    }

    public void gotopage2(View view){
        startActivity(new Intent(this,Main2Activity.class));
    }

    public void sqlite(View view){
        startActivity(new Intent(this,SQLiteProcesses.class));
    }

    public void mysql(View view) {
        startActivity(new Intent(this,MySQLProcesses.class));
    }
}
