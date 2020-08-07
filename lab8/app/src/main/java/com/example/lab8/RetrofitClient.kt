package com.example.lab8

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private var retrofit: Retrofit? = null
    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
        }
        return retrofit
    }

    private val client: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor { chain ->
        var request = chain.request()
        val requestBuilder = request.newBuilder()
        request = requestBuilder.build()
        val response = chain.proceed(request)
        val responseString = String(response.body()!!.bytes())
        Log.v("JSON", "Response: $responseString")
        response.newBuilder()
            .body(ResponseBody.create(response.body()!!.contentType(), responseString))
            .build()
    }

}