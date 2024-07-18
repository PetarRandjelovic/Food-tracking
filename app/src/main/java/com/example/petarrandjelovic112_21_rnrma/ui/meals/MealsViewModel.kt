package com.example.petarrandjelovic112_21_rnrma.ui.meals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petarrandjelovic112_21_rnrma.data.repository.CategoryRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealRepository
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MealsViewModel( private val mealRepository: MealRepository) : ViewModel(),



    MainContract.MealsViewModel {

    private val mealsD = CompositeDisposable()
    override val meals: MutableLiveData<List<Meal>> = MutableLiveData()
    override val meal: MutableLiveData<Meal> = MutableLiveData()






    override fun getMeals(id: String) {
        val meal = mealRepository
            .getAllMeals(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;
                    println(it)
                    println("IT")

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        mealsD.add(meal)
    }

    override fun getMealsByArea(id: String) {
        val meal = mealRepository
            .getAllMealsByArea(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;
                    println(it)
                    println("IT")

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        mealsD.add(meal)
    }

    override fun getMealsByIngredients(id: String) {
        val meal = mealRepository
            .getAllMealsByIngredients(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;
                    println(it)
                    println("IT")

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        mealsD.add(meal)
    }

    override fun getMealsByName(id: String) {
        val meal = mealRepository
            .getAllMealsByName(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;
                    println(it)
                    println("IT")

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        mealsD.add(meal)
    }
}