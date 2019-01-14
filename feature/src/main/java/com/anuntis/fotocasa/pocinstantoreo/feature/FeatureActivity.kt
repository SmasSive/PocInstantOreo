package com.anuntis.fotocasa.pocinstantoreo.feature

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FeatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        startNotifier()
    }

    private fun startNotifier() {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

        applicationContext?.registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                findViewById<TextView>(R.id.textView).text = "Broadcast received!"
            }
        }, filter)
    }
}
