package com.example.lab8.interfaces

import com.example.lab8.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIUrl {
    @GET("hound/{dog_name}/images")
    fun getUrlImageList(@Path("dog_name") dog_name: String): Call<Model>
}