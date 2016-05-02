package com.mac.chris.intentservices;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.text.format.DateFormat;


public class MyIntentService extends IntentService {

    public static final String TEXT_INPUT = "inText";
    public static final String TEXT_OUTPUT = "outText";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String inputText = intent.getStringExtra(TEXT_INPUT);
        SystemClock.sleep(3000);
        String outputText = inputText + " "
                + DateFormat.format("dd/MM/yy h:mm:ss aa",System.currentTimeMillis());

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.ResponseReceiver.LOCAL_ACTION);
        broadcastIntent.putExtra(TEXT_OUTPUT, outputText);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.sendBroadcast(broadcastIntent);
    }
}