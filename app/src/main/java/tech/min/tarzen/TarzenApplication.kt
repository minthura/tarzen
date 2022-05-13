package tech.min.tarzen

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.*
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class TarzenApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG) {
            plant(DebugTree())
        }
    }
}