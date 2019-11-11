package cl.gringraz.itunesclient

import android.app.Application
import cl.gringraz.itunesclient.di.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ItunesClientApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@ItunesClientApplication)
            modules(searchModule)
        }
    }
}
