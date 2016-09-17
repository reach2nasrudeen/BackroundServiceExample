package com.nasrudeen.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if ((intent.getAction().equals(Intent.ACTION_USER_PRESENT))
                || (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))) {
            startService(new Intent(getBaseContext(), MyService.class));
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
