package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import io.reactivex.Observable

interface MealRepository {

    fun getAllMeals(id: String): Observable<List<Meal>>

    fun getAllMealsByArea(id: String): Observable<List<Meal>>

    fun getAllMealsByIngredients(id: String): Observable<List<Meal>>

    fun getAllMealsByName(id: String): Observable<List<Meal>>
}