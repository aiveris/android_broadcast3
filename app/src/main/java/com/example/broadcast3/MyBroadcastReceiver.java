package com.example.broadcast3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    public MyBroadcastReceiver() { }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("RECIEVER", intent.getAction() + "=========");

        if(intent.getAction() == null){
            return;
        }

        if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){//==========AIRPLANE MODE
            boolean Mode_On = intent.getBooleanExtra("state", false);
            if(Mode_On){
                Log.e("RECEIVER","AirPlane Mode is ON");
            }
            else{
                Log.e("RECEIVER","AirPlane Mode is OFF");
            }
        }//============================================================================================

        else {//=======================================================================PHONE STATE
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String state = bundle.getString(TelephonyManager.EXTRA_STATE);
                Log.e("RECIEVER", state);
                if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    String phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Log.e("RECIEVER", phoneNumber);
                }
            }
        }//============================================================================================
    }
}