package com.nasrudeen.serviceexample;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.app.Service;
/**
 * Created by Nasrudeen on 9/17/2016.
 */
public class MyService extends Service {
    private Context mContext;
    Handler handler;
    Runnable runnableThread;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        mContext = this;
        Toast.makeText(mContext, "Service Started", Toast.LENGTH_LONG).show();
        handler = new Handler();
        runnableThread = new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                Toast.makeText(mContext, "Service Running", Toast.LENGTH_LONG).show();
                Log.i("BG Service App --> ","Service Running");
                handler.postDelayed(runnableThread, 10000);
            }
        };
        handler.postDelayed(runnableThread, 1500);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnableThread);
        Log.i("BG Service App --> ","Service Destroyed");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}
