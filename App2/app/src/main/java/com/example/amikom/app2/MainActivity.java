package com.example.amikom.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView ShowCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CountUp(View view) {
        ShowCount= (TextView) findViewById(R.id.ShowCount);
        mCount++;
        if (ShowCount != null)
            ShowCount.setText(Integer.toString(mCount));
    }

    public void ShowToast (View view){
        Toast toast = Toast.makeText(this,R.string.onClick_btntoast, Toast.LENGTH_LONG);
        toast.show();
    }
}

