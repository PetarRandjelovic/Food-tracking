package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.data.datasource.MainDataSource
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import io.reactivex.Observable

class MealRepositoryImpl (private val mainDataSource: MainDataSource) :MealRepository{



    override fun getAllMeals(id: String): Observable<List<Meal>> {
        return mainDataSource
            .getMealsByCategory(id)
            .map {
                it.meals.map { mealResponse ->
                    Meal(



                        idMeal = mealResponse.idMeal!!,
                        strMeal = mealResponse.strMeal!!,
                        strMealThumb = mealResponse.strMealThumb,

                    )
                }
            }
    }

    override fun getAllMealsByArea(id: String): Observable<List<Meal>> {
        return mainDataSource
            .getMealsByArea(id)
            .map {
                it.meals.map { mealResponse ->
                    Meal(



                        idMeal = mealResponse.idMeal!!,
                        strMeal = mealResponse.strMeal!!,
                        strMealThumb = mealResponse.strMealThumb,

                        )
                }
            }
    }

    override fun getAllMealsByIngredients(id: String): Observable<List<Meal>> {
        return mainDataSource
            .getMealsByIngredient(id)
            .map {
                it.meals.map { mealResponse ->
                    Meal(



                        idMeal = mealResponse.idMeal!!,
                        strMeal = mealResponse.strMeal!!,
                        strMealThumb = mealResponse.strMealThumb,

                        )
                }
            }
    }

    override fun getAllMealsByName(id: String): Observable<List<Meal>> {
        return mainDataSource
            .getFilterByName(id)
            .map {
                it.meals.map { mealResponse ->
                    Meal(

                        idMeal = mealResponse.idMeal!!,
                        strMeal = mealResponse.strMeal!!,
                        strMealThumb = mealResponse.strMealThumb,


                        )
                }
            }
    }


}