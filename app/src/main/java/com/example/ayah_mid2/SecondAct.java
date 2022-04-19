package com.example.ayah_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondAct extends AppCompatActivity {

    int count =1;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button bttnfirstAct=(Button)findViewById(R.id.buttonView);

        Button bttnSearch=(Button)findViewById(R.id.bttnSearch);

        EditText id_val=(EditText)findViewById(R.id.id);

        bttnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String idvalue = id_val.getText().toString();
                    db.getSpecificResult(idvalue);

                }
                catch (Exception e){
                    count=1;
                    Toast.makeText(SecondAct.this,"Unsuccessful Search, please insert ID",Toast.LENGTH_LONG).show();
                }
            }});

        bttnfirstAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondAct.this,MainActivity.class));
            }
        });
    }
}