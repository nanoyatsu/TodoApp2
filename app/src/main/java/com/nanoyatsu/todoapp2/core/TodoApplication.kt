package com.nanoyatsu.todoapp2.core

import android.app.Application
import android.content.Context

class TodoApplication : Application() {
    companion object {
        lateinit var appContext: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}