package com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealDetailsRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealRepository
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class DetailedMealModel( private val mealDetailsRepository: MealDetailsRepository) : ViewModel(), MainContract.DetailedMealModel {



    override val meal: MutableLiveData<MealDetails> = MutableLiveData()
    override val meals: MutableLiveData<List<MealDetails>> = MutableLiveData()
    private val mealsD = CompositeDisposable()

    override fun getMeal(id: String) {
        val meals = mealDetailsRepository
            .getMeal(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        mealsD.add(meals)
    }


}