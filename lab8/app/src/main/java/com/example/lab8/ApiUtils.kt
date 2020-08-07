package com.example.lab8

import com.example.lab8.interfaces.APIService
import com.example.lab8.interfaces.APIUrl

class ApiUtils (){

    var BASE_URL = "https://dog.ceo/api/breed/"

    fun getAPIService(): APIService {
        return RetrofitClient().getClient(BASE_URL)!!.create(APIService::class.java)
    }
    fun getAPIUrl(): APIUrl {
        return RetrofitClient().getClient(BASE_URL)!!.create(APIUrl::class.java)
    }
}