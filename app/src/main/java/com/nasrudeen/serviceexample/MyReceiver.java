package com.nasrudeen.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if ((intent.getAction().equals(Intent.ACTION_USER_PRESENT))
                || (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))) {
//            Intent i = new Intent(context, MyService.class);
//            context.startService(i);
            Toast.makeText(context,"Test service",Toast.LENGTH_SHORT).show();
            context.startService(new Intent(context, MyService.class));
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
