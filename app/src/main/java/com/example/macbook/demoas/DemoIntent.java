package com.example.macbook.demoas;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by macbook on 9/12/16.
 */
public class DemoIntent extends IntentService
{
    public DemoIntent() {
        super("DemoIntent");

    }
    int k =0;
    int count =0;
    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i =2;i <= 1000000;i++)
        {
            if(isPrime(i))
            {

                count++;
                k++;
                Log.d("COUNT",count+"");
                if(k == 1000)
                {
                    k=0;
                            EventBus.getDefault().post(new EventBusDemo(i+""));

                }
            }
        }
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
