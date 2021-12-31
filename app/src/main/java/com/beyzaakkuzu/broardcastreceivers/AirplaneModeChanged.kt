package com.beyzaakkuzu.broardcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChanged: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       val isAirplaneModeEnable=intent?.getBooleanExtra("State", false)?: return
        if(isAirplaneModeEnable){
            Toast.makeText(context, "Airplane mode enabled.", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Airplane mode disabled.", Toast.LENGTH_LONG).show()
        }
    }
}