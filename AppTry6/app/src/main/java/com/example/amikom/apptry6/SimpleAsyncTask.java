package com.example.amikom.apptry6;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by amikom on 19/11/2018.
 */

public class SimpleAsyncTask extends AsyncTask<Void, Void, String>{

    TextView mTextView;
    Context ctx;
    ProgressDialog pd;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mTextView);
        pd.setTitle("Downloading");
        pd.setMessage("Please Wait.....");
        pd.setMax(10);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });

        pd.show();
    }


    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n* 200;

        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Please Wait "+ s +" Milisecond";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }

    public SimpleAsyncTask(TextView tv){
        mTextView = tv;
    }
}
