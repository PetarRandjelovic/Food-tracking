package com.example.petarrandjelovic112_21_rnrma.model

class Ingredients {

    private var idIngredient = 0
    private var strIngredient: String? = null
    private var strDescription:String?=null

    private var strType:String?=null


    constructor(idIngredient: Int, strIngredient: String?, strDescription: String?, strType: String?) {


        this.idIngredient = idIngredient
        this.strIngredient = strIngredient
        this.strDescription = strDescription
        this.strType=strType;

    }

    fun getIdIngredient(): Int? {
        return idIngredient
    }


    fun getStrIngredient(): String? {
        return strIngredient
    }
    fun getStrDescription(): String? {
        return strDescription
    }


    fun getStrType(): String? {
        return strType
    }


}