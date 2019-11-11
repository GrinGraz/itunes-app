package cl.gringraz.itunesclient.data.source

import cl.gringraz.itunesclient.data.source.remote.ItunesApi
import cl.gringraz.itunesclient.data.source.remote.ItunesDataSource
import cl.gringraz.itunesclient.data.source.remote.RemoteDataSource
import cl.gringraz.itunesclient.di.URL_BASE_ITUNES_SEARCH_API
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val testModule = module {
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

    single<ItunesApi> {
        get<Retrofit>()
            .create(ItunesApi::class.java)
    }

    factory<RemoteDataSource> { ItunesDataSource(get()) }
}
