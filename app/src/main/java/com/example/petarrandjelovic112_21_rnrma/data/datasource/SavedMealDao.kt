package com.example.petarrandjelovic112_21_rnrma.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import com.example.petarrandjelovic112_21_rnrma.model.SavedMealsCount
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
abstract class SavedMealDao {

    @Insert
    abstract fun insert(courseEntity: MealSave): Completable



    @Query("DELETE FROM saved_meals")
    abstract fun deleteAll(): Completable

    @Query("SELECT * from saved_meals")
    abstract fun selectAll(): Observable<List<MealSave>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSavedMeal(mealSave: MealSave): Completable

    @Update
    abstract fun update(mealSave: MealSave)

    @Query("UPDATE saved_meals SET strMeal = :name,strYoutube = :strYoutube,strInstructions = :strInstructions WHERE id == :id")
    abstract fun updateMealById(id: Long, name: String, strYoutube: String, strInstructions: String): Completable

    @Query("DELETE FROM saved_meals WHERE id == :id")
    abstract fun deleteById(id: Int): Completable


    @Query("SELECT strftime('%Y-%m-%d', saved_date / 1000, 'unixepoch') AS formatted_date, COUNT(*) AS meals_count FROM saved_meals WHERE saved_date >= strftime('%s', date('now', '-7 days')) * 1000 GROUP BY formatted_date")
    abstract fun getMealFromLast7Days(): Observable<List<SavedMealsCount>>



}