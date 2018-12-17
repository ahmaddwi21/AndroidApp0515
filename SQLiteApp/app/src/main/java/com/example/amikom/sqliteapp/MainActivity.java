package com.example.amikom.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name, college;

    MyCoreDatabase MyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.editStudent);
        college = (EditText)findViewById(R.id.editCollege);

        MyData = new MyCoreDatabase(this);
    }


    public void OnLoad(View view) {
        MyData.getAll();
    }

    public void OnSave(View view) {
        MyData.insertData(name.getText().toString(), college.getText().toString());
    }
}
