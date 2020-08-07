package com.example.lab8.interfaces

import com.example.lab8.Model
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("hound/list")
    fun getListDog(): Call<Model>
}
