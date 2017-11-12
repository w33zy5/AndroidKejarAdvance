package com.example.dewaagung.advancetraining.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Dewa Agung on 12/11/17.
 */

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service Started");
        new DoSomething().execute();
        return super.onStartCommand(intent, flags, startId);
    }

    public IBinder onBind(Intent intent){
        return null;
    }

    private class DoSomething extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=0; i<=10; i++){
                try{
                    Thread.sleep(1000);
                    Log.i(TAG, "doInBackground -> "+i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
