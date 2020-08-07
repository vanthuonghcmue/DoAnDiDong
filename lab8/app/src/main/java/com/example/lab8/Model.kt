package com.example.lab8

import com.google.gson.annotations.SerializedName

class Model {
    var status: String = ""
    @SerializedName("message")
    var listDog: List<String>? = null

}