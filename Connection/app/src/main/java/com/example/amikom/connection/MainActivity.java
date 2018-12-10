package com.example.amikom.connection;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    static TextView myText;
    static ImageView myImage;

    ConnectInternet c1;

    ConnectivityManager myConnMgr;
    NetworkInfo myInfo;
    DownloadImage downloadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText = (TextView)findViewById(R.id.myResult);
        myImage = (ImageView)findViewById(R.id.myImageResult);

        myConnMgr = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnMgr.getActiveNetworkInfo();

    }

    public void webpage(View view){
        c1 = new ConnectInternet(this);
        c1.execute("http://www.google.com");
    }

    public void downloadImg(View view) {
        if (myInfo != null && myInfo.isConnected()){
            downloadImage = new DownloadImage();
            downloadImage.execute("https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/3/39/AoU_Iron_Man_Mk43_art.png/revision/latest?cb=20150310052243");
        }
        else {
            Toast.makeText(this, "Internet Not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}
