package cl.gringraz.itunesclient.di

import androidx.fragment.app.Fragment
import cl.gringraz.itunesclient.data.repository.RemoteDataRepository
import cl.gringraz.itunesclient.data.source.remote.ItunesApi
import cl.gringraz.itunesclient.data.source.remote.ItunesDataSource
import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource
import cl.gringraz.itunesclient.domain.repository.RemoteRepository
import cl.gringraz.itunesclient.util.ViewModelFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val URL_BASE_ITUNES_SEARCH_API = "https://itunes.apple.com/"

val searchModule = module {
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_ITUNES_SEARCH_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>()
            .create(ItunesApi::class.java) as ItunesApi
    }

    factory<RemoteDataSource> { ItunesDataSource(get()) }

    single<RemoteRepository> { RemoteDataRepository(get()) }

    single { ViewModelFactory(get()) }
}
