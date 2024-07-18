package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.data.datasource.MainDataSource
import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import io.reactivex.Observable

class IngredientsRepositoryImpl(private val mainDataSource: MainDataSource) :IngredientsRepository  {



    override fun getAllIngredients(): Observable<List<Ingredients>> {
        return mainDataSource
            .getAllIngredients()
            .map {
                it.meals.map { ingredientResponse ->
                    Ingredients(


                        idIngredient = ingredientResponse.idIngredient!!,
                        strIngredient = ingredientResponse.strIngredient,
                        strDescription = ingredientResponse.strDescription,
                        strType = ingredientResponse.strType,
                    )
                }
            }
    }


}