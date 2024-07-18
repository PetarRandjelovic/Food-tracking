package com.example.petarrandjelovic112_21_rnrma.ui.filterPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petarrandjelovic112_21_rnrma.data.repository.AreaRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.CategoryRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.IngredientsRepository
import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.Category

import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class FilterViewModel(private val ingredientRepository: IngredientsRepository,private val areaRepository: AreaRepository
                      ,private val categoryRepository: CategoryRepository) : ViewModel(),
    MainContract.FilterViewModel {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private val ingredientsD = CompositeDisposable()
    override val ingredients: MutableLiveData<List<Ingredients>>  = MutableLiveData()
    override val ingredient: MutableLiveData<Ingredients> =MutableLiveData()


    private val areaD = CompositeDisposable()
    override val areas: MutableLiveData<List<Area>> = MutableLiveData()
    override val area: MutableLiveData<Area> = MutableLiveData()

    private var currentPage = 1
    private var totalPages = 1


    override fun getIngredients() {
        val ingredient = ingredientRepository
            .getAllIngredients()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    ingredients.value=it;

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        ingredientsD.add(ingredient)
    }

    override fun getAreas() {
        val area = areaRepository
            .getAllAreas()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    areas.value=it;

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        areaD.add(area)
    }

    override val categories: MutableLiveData<List<Category>> = MutableLiveData()

    override val category: MutableLiveData<Category> = MutableLiveData()


    override fun getCategories() {
        val category = categoryRepository
            .getAllCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    categories.value=it;

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        areaD.add(category)
    }



}