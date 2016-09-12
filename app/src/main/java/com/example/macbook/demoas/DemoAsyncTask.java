package com.example.macbook.demoas;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by macbook on 9/9/16.
 */
public class DemoAsyncTask extends AsyncTask<String, Integer, String>
{

    int count = 0;
    @Override
    protected String doInBackground(String... strings) {
        for(int i =2;i <= 1000000;i++)
        {
            if(isPrime(i))
            {
                count++;
                publishProgress(count);
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d("COUNT",values[0]+"");
    }

    boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}
