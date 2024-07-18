package com.example.petarrandjelovic112_21_rnrma.ui.saveMeal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petarrandjelovic112_21_rnrma.data.repository.SavedMealRepository
import com.example.petarrandjelovic112_21_rnrma.model.MealSave
import com.example.petarrandjelovic112_21_rnrma.model.SavedMealsCount
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SaveMealModel(
    private val savedMealRepository: SavedMealRepository,
    override val meals: MutableLiveData<List<MealSave>> = MutableLiveData(),
    override val savedMealsCount: MutableLiveData<List<SavedMealsCount>> = MutableLiveData()


): ViewModel(), MainContract.SaveMealModel {

    private val subscriptions = CompositeDisposable()

    override fun getAllSavedMeals() {
        val subscription = savedMealRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    meals.value=it;
                    Timber.e("$it")
                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("ON COMPLETE")
                }
            )
        subscriptions.add(subscription)
    }

    override fun instertSavedMeal(mealSave: MealSave) {
        val subscription = savedMealRepository
            .insert(mealSave)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("COMPLETE")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteAllStudents() {
        val subscription = savedMealRepository
            .deleteAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteMeal(id: Int) {

        val subscription = savedMealRepository
            .deleteMeal(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun updateMealById(
        id: Long,
        name: String,
        strYoutube: String,
        strInstructions: String
    ) {
        val subscription = savedMealRepository
            .updateMealById(id,name,strYoutube,strInstructions)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getMealFromLast7Days() {
        val subscription = savedMealRepository
            .getMealFromLast7Days()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {

                    savedMealsCount.value=it

                    Timber.e("DELETED")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }
}