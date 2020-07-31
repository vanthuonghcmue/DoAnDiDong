package com.example.tikicloneapp.Model

class User {
    private var fullname: String = ""
    private var email: String = ""
    private var bio: String = ""
    private var image: String = ""
    private var phone: String = ""
    private var uid: String = ""
    private var date: String =""

    constructor()

    constructor(fullName:String, email:String,phone:String, bio:String, image: String, uid:String, date: String ){
        this.fullname=fullname
        this.email=email
        this.bio=bio
        this.image=image
        this.phone=phone
        this.uid=uid
        this.date=date
    }
    fun  getFullname():String{
        return fullname
    }
    fun  setFullname(fullname:String){
        this.fullname=fullname
    }
    fun  getDate():String{
        return date
    }
    fun  setDate(date:String){
        this.date=date
    }
    fun  getPhone():String{
        return phone
    }
    fun  setPhone(phone:String){
        this.phone=phone
    }
    fun  getEmail():String{
        return email
    }
    fun  setEmail(email:String){
        this.email=email
    }
    fun  getBio():String{
        return bio
    }
    fun  setBio(bio:String){
        this.bio=bio
    }
    fun  getImage():String{
        return image
    }
    fun  setImage(image:String){
        this.image=image
    }
    fun  getUID():String{
        return uid
    }
    fun  setUID(uid:String){
        this.uid=uid
    }
}