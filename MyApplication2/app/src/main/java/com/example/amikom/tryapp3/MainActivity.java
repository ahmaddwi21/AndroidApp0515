package com.example.amikom.tryapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);

        registerForContextMenu(e1);
        registerForContextMenu(e2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mic :
                Toast.makeText(this,"You Clicked MIC", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.setting :
                Toast.makeText(this,"You Clicked Settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.status :
                Toast.makeText(this, "You Clicked Status", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case  R.id.editText :
                getMenuInflater().inflate(R.menu.edit_menu1,menu);
                break;
            case R.id.editText2 :
                getMenuInflater().inflate(R.menu.edit_menu2,menu);
                break;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.i1 :
                Toast.makeText(this,"You Clicked Item 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i2 :
                Toast.makeText(this,"You Clicked Item 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3 :
                Toast.makeText(this,"You Clicked Item 3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i4 :
                Toast.makeText(this,"You Clicked Item 4",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
