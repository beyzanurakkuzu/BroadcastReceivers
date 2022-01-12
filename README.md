# Broadcast Receivers :exclamation:

Android system and other Android apps, similar to the publish-subscribe design pattern. These broadcasts are sent when an event of interest occurs. For example, the Android system sends broadcasts when various system events occur, such as when the system boots up or the device starts charging. Apps can also send custom broadcasts, for example, to notify other apps of something that they might be interested in (for example, some new data has been downloaded).

**Airplane Mode Changed Class**

he broadcast message itself is wrapped in an Intent object whose action string identifies the event that occurred *(android.intent.action.AIRPLANE_MODE)*. The intent may also include additional information bundled into its extra field. For example, the airplane mode intent includes a boolean extra that indicates whether or not Airplane Mode is on. 
```kotlin
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
```

**Main Activity**

```kotlin

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
```
