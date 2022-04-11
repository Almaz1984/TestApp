package com.home.testapplication

import android.app.Application
import android.widget.Toast

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val preferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val launchCounter = preferences.getInt(LAUNCH_COUNTER_KEY, DEFAULT_VALUE).inc()

        if (launchCounter == MAX_COUNTER) {
            showToast("Number of launches is $launchCounter")
        }

        preferences.edit().apply {
            putInt(LAUNCH_COUNTER_KEY, launchCounter)
            apply()
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val MAX_COUNTER = 3
        const val DEFAULT_VALUE = 0
        const val APP_PREFERENCES = "app_preferences"
        const val LAUNCH_COUNTER_KEY = "launch counter"
    }
}
