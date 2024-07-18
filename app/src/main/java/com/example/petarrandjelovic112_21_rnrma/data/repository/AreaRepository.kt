package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.Category
import io.reactivex.Observable

interface AreaRepository {

    fun getAllAreas(): Observable<List<Area>>

}