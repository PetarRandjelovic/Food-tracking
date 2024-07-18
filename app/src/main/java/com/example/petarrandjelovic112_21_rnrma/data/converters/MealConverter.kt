package com.example.petarrandjelovic112_21_rnrma.data.converters

import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import java.util.Date

class MealConverter {
    companion object{
        fun fromMeal(value: MealDetails?,spinner: String?,date :Date): MealSave? {
            if (value == null) {
                return null
            }

            return try {
                MealSave(

                    value.idMeal.toInt(),
                    value.idMeal,
                    value.strMeal,
                    value.strDrinkAlternate.toString(),
                    value.strCategory,
                    value. strArea,
                    value.strInstructions,
                    value. strMealThumb,
                      value. strTags,
                    value. strYoutube,
                    value. strIngredient1,
                    value. strIngredient2,
                    value.   strIngredient3,
                    value.  strIngredient4,
                    value.  strIngredient5,
                    value.   strIngredient6,
                    value.strIngredient7,
                    value.strIngredient8,
                    value. strIngredient9,
                    value.strIngredient10,
                    value.strIngredient11,
                    value.strIngredient12,
                    value.strIngredient13,
                    value. strIngredient14,
                    value.strIngredient15,
                    value.strIngredient16,
                    value. strIngredient17,
                    value.strIngredient18,
                    value.strIngredient19,
                    value.strIngredient20,
                    value.strMeasure1,
                    value. strMeasure2,
                    value. strMeasure3,
                    value. strMeasure4,
                    value. strMeasure5,
                    value.strMeasure6,
                    value. strMeasure7,
                    value. strMeasure8,
                    value.strMeasure9,
                    value. strMeasure10,
                    value. strMeasure11,
                    value. strMeasure12,
                    value. strMeasure13,
                    value. strMeasure14,
                    value.strMeasure15,
                    value.strMeasure16,
                    value. strMeasure17,
                    value.  strMeasure18,
                    value. strMeasure19,
                    value.  strMeasure20,
                    value.  strSource,
                    value. strImageSource,
                    value. strCreativeCommonsConfirmed,
                    value.dateModified,
                    savedDate = date.time,
                    spinner!!
                )
            } catch (e: Exception) {
                throw IllegalArgumentException("Error converting meal to entity", e)
            }
        }


        fun toMealDetail(value: MealSave?): MealDetails? {
            if (value == null) {
                return null
            }

            return try {
                MealDetails(

                    value.idMeal,
                    value.strMeal,
                    value.strDrinkAlternate.toString(),
                    value.strCategory,
                    value. strArea,
                    value.strInstructions,
                    value. strMealThumb,
                    value. strTags,
                    value. strYoutube,
                    value. strIngredient1,
                    value. strIngredient2,
                    value.   strIngredient3,
                    value.  strIngredient4,
                    value.  strIngredient5,
                    value.   strIngredient6,
                    value.strIngredient7,
                    value.strIngredient8,
                    value. strIngredient9,
                    value.strIngredient10,
                    value.strIngredient11,
                    value.strIngredient12,
                    value.strIngredient13,
                    value. strIngredient14,
                    value.strIngredient15,
                    value.strIngredient16,
                    value. strIngredient17,
                    value.strIngredient18,
                    value.strIngredient19,
                    value.strIngredient20,
                    value.strMeasure1,
                    value. strMeasure2,
                    value. strMeasure3,
                    value. strMeasure4,
                    value. strMeasure5,
                    value.strMeasure6,
                    value. strMeasure7,
                    value. strMeasure8,
                    value.strMeasure9,
                    value. strMeasure10,
                    value. strMeasure11,
                    value. strMeasure12,
                    value. strMeasure13,
                    value. strMeasure14,
                    value.strMeasure15,
                    value.strMeasure16,
                    value. strMeasure17,
                    value.  strMeasure18,
                    value. strMeasure19,
                    value.  strMeasure20,
                    value.  strSource,
                    value. strImageSource,
                    value. strCreativeCommonsConfirmed,
                    value.dateModified,
                    
                )
            } catch (e: Exception) {
                throw IllegalArgumentException("Error converting entity to meal", e)
            }
        }

        fun toMealFromMealDetail(value: MealDetails?): Meal? {
            if (value == null) {
                return null
            }

            return try {
                Meal(

                    value.idMeal.toInt(),
                    value.strMeal,
                    value.strMealThumb,


                    )
            } catch (e: Exception) {
                throw IllegalArgumentException("Error converting entity to meal", e)
            }
        }
        fun toMealFromMealSave(value: MealSave?): Meal? {
            if (value == null) {
                return null
            }

            return try {
                Meal(

                    value.idMeal.toInt(),
                    value.strMeal,
                    value.strMealThumb,


                    )
            } catch (e: Exception) {
                throw IllegalArgumentException("Error converting entity to meal", e)
            }
        }

    }

}