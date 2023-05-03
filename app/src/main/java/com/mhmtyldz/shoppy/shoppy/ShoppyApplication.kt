package com.mhmtyldz.shoppy.shoppy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant


/**
created by Mehmet E. Yıldız
 **/
@HiltAndroidApp
class ShoppyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }
}