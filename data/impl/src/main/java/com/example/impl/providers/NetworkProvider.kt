package com.example.impl.providers

import com.google.gson.GsonBuilder
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkProvider(
    private val host: String
) {

    private val headerInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("X-Api-Key", "304aa4d511b24a89961d561e65d6f393")
            .build()
        chain.proceed(modifiedRequest)
    }


    private val client = OkHttpClient.Builder().apply {
        readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
        connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
        addInterceptor(headerInterceptor)
//        addInterceptor(
//            HttpLoggingInterceptor().apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//        )
    }.build()

    fun <T> provideRetrofit(
        clazz: Class<T>,
    ): T {
        return Retrofit.Builder()
            .baseUrl(host)
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setLenient().create()
                )
            )
            .build()
            .create(clazz)
    }

    companion object {
        private const val CONNECT_TIME_OUT: Long = 30
        private const val READ_TIME_OUT: Long = 15
    }

}