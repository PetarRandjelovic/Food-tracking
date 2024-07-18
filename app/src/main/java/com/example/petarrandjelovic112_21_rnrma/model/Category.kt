package com.example.petarrandjelovic112_21_rnrma.model

class Category {

    private var id = 0
    private var strCategory: String? = null
    private var picture:String?=null

    private var description:String?=null

    constructor(id: Int, picture: String, description: String, strCategory: String) {


        this.id = id
        this.picture = picture
        this.description = description
        this.strCategory=strCategory;

    }
    fun getId(): Int? {
        return id
    }


    fun getPicture(): String? {
        return picture
    }
    fun getStr(): String? {
        return strCategory
    }


    fun getDescription(): String? {
        return description
    }



}