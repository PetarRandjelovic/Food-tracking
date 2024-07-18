package com.example.petarrandjelovic112_21_rnrma.ui.contract

import androidx.lifecycle.LiveData
import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import com.example.petarrandjelovic112_21_rnrma.model.SavedMealsCount

interface MainContract {


    interface FilterViewModel {
        val ingredients: LiveData<List<Ingredients>>
        val ingredient: LiveData<Ingredients>
        //  val postCategories: LiveData<List<Categories>>
        val areas: LiveData<List<Area>>
        val area: LiveData<Area>

        fun getIngredients()
        fun getAreas()


        val categories: LiveData<List<Category>>
        val category: LiveData<Category>





        fun getCategories()
    }



    interface CategoryViewModel {
        val categories: LiveData<List<Category>>
        val category: LiveData<Category>

        fun getCategories()


    }

    interface MealsViewModel {
        val meals: LiveData<List<Meal>>
        val meal: LiveData<Meal>

        fun getMeals(id: String)
        fun getMealsByArea(id: String)
        fun getMealsByIngredients(id: String)
        fun getMealsByName(id: String)

    }


    interface DetailedMealModel {
        val meal: LiveData<MealDetails>
        val meals: LiveData<List<MealDetails>>

        fun getMeal(id: String)

    }


    interface SaveMealModel {
        val meals: LiveData<List<MealSave>>
        val savedMealsCount: LiveData<List<SavedMealsCount>>


        fun getAllSavedMeals()
        fun instertSavedMeal(mealSave: MealSave)
        fun deleteAllStudents()
        fun deleteMeal(id: Int)
        fun updateMealById(id: Long, name: String, strYoutube: String, strInstructions: String)
        fun getMealFromLast7Days()
    }

}