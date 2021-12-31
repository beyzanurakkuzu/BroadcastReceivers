package com.beyzaakkuzu.broardcastreceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var recevier:AirplaneModeChanged

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recevier=AirplaneModeChanged()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            registerReceiver(recevier,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(recevier)
    }
}