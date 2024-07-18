package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import com.example.petarrandjelovic112_21_rnrma.model.SavedMealsCount
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.Date

interface SavedMealRepository {

    fun getAll(): Observable<List<MealSave>>

    fun insert(mealSave: MealSave): Completable

    fun deleteAll(): Completable

    fun deleteMeal(id: Int): Completable

    fun updateMealById(id: Long, name: String, strYoutube: String, strInstructions: String): Completable

    fun getMealFromLast7Days(): Observable<List<SavedMealsCount>>
}