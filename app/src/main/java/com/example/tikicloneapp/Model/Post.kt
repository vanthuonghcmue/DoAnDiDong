package com.example.tikicloneapp.Model

import com.google.firebase.database.Exclude

class Post {
    private var giaban: Int = 0
    private var giagoc: Int = 0
    private var giamgia: Int = 0
    private var hinh: String = ""

    private var postid: String = ""
    private var tikinow: Int = 1
    private var name: String = ""


    constructor()
    constructor(
        giaban: Int,
        giagoc: Int,
        giamgia: Int,
        hinh: String,
        postid: String,
        name: String
    ) {
        this.postid = postid
        this.giaban = giaban
        this.giagoc = giagoc
        this.giamgia = giamgia
        this.hinh = hinh
        this.name = name

    }

    fun getpostid(): String {
        return postid
    }

    fun getgiaban(): Int {
        return giaban
    }

    fun getgiagoc(): Int {
        return giagoc
    }

    fun getgiamgia(): Int {
        return giamgia
    }

    fun gethinh(): String {
        return hinh
    }

    fun getname(): String {
        return name
    }

    fun gettikinow(): Int {
        return tikinow
    }

    fun setgiaban(giaban: Int) {
        this.giaban = giaban
    }

    fun setpostid(postid: String) {
        this.postid = postid
    }

    fun setgiamgia(giamgia: Int) {
        this.giamgia = giamgia
    }

    fun setgiagoc(giagoc: Int) {
        this.giagoc = giagoc
    }

    fun sethinh(hinh: String) {
        this.hinh = hinh
    }

    fun setname(name: String) {
        this.name = name
    }

    fun settikinow(tikinow: Int) {
        this.tikinow = tikinow
    }

    @Exclude
    fun toMap(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("postid", postid!!)
        result.put("giaban", giaban!!)

        result.put("giagoc", giagoc!!)
        result.put("giamgia", giamgia!!)
        result.put("hinh", hinh!!)
        result.put("name", name!!)


        return result
    }
}