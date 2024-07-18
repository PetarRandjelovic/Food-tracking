package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.data.datasource.SavedMealDao
import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import com.example.petarrandjelovic112_21_rnrma.model.SavedMealsCount
import io.reactivex.Completable
import io.reactivex.Observable
import java.util.Date

class SaveMealRepositoryImpl(private val savedMealDao: SavedMealDao): SavedMealRepository {
    override fun getAll(): Observable<List<MealSave>> {
        return savedMealDao.selectAll()
    }

    override fun insert(mealSave: MealSave): Completable {
        return savedMealDao.insertSavedMeal(mealSave)
    }

    override fun deleteAll(): Completable {
        return savedMealDao.deleteAll()
    }

    override fun deleteMeal(id: Int): Completable {
        return savedMealDao.deleteById(id)
    }

    override fun updateMealById(
        id: Long,
        name: String,
        strYoutube: String,
        strInstructions: String
    ): Completable {
    return   savedMealDao.updateMealById(id,name,strYoutube,strInstructions)
    }

    override fun getMealFromLast7Days(): Observable<List<SavedMealsCount>>  {
        return savedMealDao.getMealFromLast7Days()
    }


}