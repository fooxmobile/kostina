package ru.fooxer.devlife

import android.app.Application

class App: Application() {
    val appComponent= DaggerApplicationComponent.create()
}