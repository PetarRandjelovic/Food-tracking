package com.example.petarrandjelovic112_21_rnrma.data.datasource


import com.example.petarrandjelovic112_21_rnrma.data.models.api.AreaResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.AreasResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.CategoriesResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.IngredientResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.IngredientsResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.MealDetailsResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.MealsDetailsResponse
import com.example.petarrandjelovic112_21_rnrma.data.models.api.MealsResponse

import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.*



interface MainDataSource {



    @GET("https://www.themealdb.com/api/json/v1/1/categories.php")
    fun getAllCategories(): Observable<CategoriesResponse>

    @GET("https://www.themealdb.com/api/json/v1/1/list.php?i=list")
    fun getAllIngredients(): Observable<IngredientsResponse>

    @GET("https://www.themealdb.com/api/json/v1/1/list.php?a=list")
    fun getAllAreas(): Observable<AreasResponse>



    @GET("https://www.themealdb.com/api/json/v1/1/filter.php")
    fun getMealsByCategory(@Query("c") id: String): Observable<MealsResponse>


    @GET("https://www.themealdb.com/api/json/v1/1/filter.php?")
    fun getMealsByIngredient(@Query("i") id: String): Observable<MealsResponse>


    @GET("https://www.themealdb.com/api/json/v1/1/filter.php?")
    fun getMealsByArea(@Query("a") id: String): Observable<MealsResponse>

    @GET("https://www.themealdb.com/api/json/v1/1/lookup.php?")
    fun getMealDetails(@Query("i") id: String): Observable<MealsDetailsResponse>

    @GET("https://www.themealdb.com/api/json/v1/1/search.php?")
    fun getFilterByName(@Query("s") id: String): Observable<MealsResponse>



}