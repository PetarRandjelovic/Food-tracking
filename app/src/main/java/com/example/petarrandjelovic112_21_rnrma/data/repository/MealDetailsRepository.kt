package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import io.reactivex.Observable


interface MealDetailsRepository {

    fun getMeal(id: String): Observable<List<MealDetails>>


}