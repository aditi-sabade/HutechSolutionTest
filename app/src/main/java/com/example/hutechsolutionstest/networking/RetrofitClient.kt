package com.example.hutechsolutionstest.networking

import com.example.hutechsolutionstest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val baseUrl = "http://139.59.83.144:9050/api/"

    public const val imageUrl = "http://139.59.83.144:9050/"

    val retrofitClient: Retrofit.Builder by lazy {

        val levelType: HttpLoggingInterceptor.Level
        if(BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }
}