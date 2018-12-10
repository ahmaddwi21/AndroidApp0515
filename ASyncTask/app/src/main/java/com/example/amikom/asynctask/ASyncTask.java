package com.example.amikom.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by amikom on 26/11/2018.
 */

public class ASyncTask extends AsyncTask<Void, Integer, String>{

    Context ctx;
    ProgressDialog pd;

    public ASyncTask(Context ct){
        ctx = ct;
    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ctx);
        pd.setTitle("Downloading");
        pd.setMessage("Please Wait...");
        pd.setMax(10);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
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
        try {
                for (int i = 1; i <= 10; i++) {
                    Random r = new Random();
                    int n = r.nextInt(11);
                    int as = n * 200;
                    Thread.sleep(as);
                    Log.i("Thread ", "Execute " + i);
                    publishProgress(i);
                }
                return "SYNCHRONIZED";
            }
        catch (Exception e){
            Log.i("Exception", e.getMessage());
            return "Failure";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int myValue = values[0];
        pd.setProgress(myValue);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx, s , Toast.LENGTH_SHORT).show();
        pd.dismiss();

    }
}
