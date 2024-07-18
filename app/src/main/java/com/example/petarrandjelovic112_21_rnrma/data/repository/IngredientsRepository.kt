package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import io.reactivex.Observable

interface IngredientsRepository {

    fun getAllIngredients(): Observable<List<Ingredients>>
}