# PoC Instant Oreo

This project is just a sample project of an instant app that has to be executed in a device with Android Oreo (8.X) to show a possible bug with a broadcast receiver.

## Introduction

One of the ways to know if we have network connectivity is to subscribe to a broadcast receiver for connectivity action, like this:

```
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

        applicationContext?.registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                findViewById<TextView>(R.id.textView).text = "Broadcast received!"
            }
        }, filter)
```

Once we receive a change in the connectivity status, we are able to determine if we are online or not and perform any action that requires network.

This is how Adobe's Analytics works in order to send tracks from the app.

## Problem

The problem here is that if you execute an instant app that uses that method in a device with Android Oreo, you won't be notified on connectivity change so you won't be able to determine if you have connectivity or not.


## Execution

- Download the project and import to your Android Studio
- Select `Edit Configurations...` in the `Run/Debug Configuration` dropdown
- Select `instantapp` module on the left of the screen
- Add this URL `http://poc/poc_detail` in the Launch options on the right of the screen
- Run `instantapp`

You will see then a screen with the text `Waiting broadcast`, if this text does not change to `Broadcast received!` you are not updating the status and therefore you have found the bug.

## Notes

This is funny because if you run the whole app you then will get the broadcast notification, that proves this issue occurs just in instant app.