package cl.gringraz.itunesclient

import android.app.Application
import cl.gringraz.itunesclient.di.searchModule
import org.koin.android.ext.android.startKoin

class ItunesClientApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(searchModule))
    }
}
