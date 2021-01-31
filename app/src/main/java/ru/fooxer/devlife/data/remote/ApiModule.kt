package ru.fooxer.devlife.data.remote

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.fooxer.devlife.ApplicationConfig
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun provideRetrofit (okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApplicationConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun bindApiService(retrofit: Retrofit) : PostApi {
        return retrofit.create(PostApi::class.java)
    }
}