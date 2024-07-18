package com.example.petarrandjelovic112_21_rnrma.model

import android.view.View

class Area {

    private var strArea: String? = null


    constructor(strArea: String?) {


        this.strArea = strArea

    }

    fun getStrArea(): String? {
        return strArea
    }
}