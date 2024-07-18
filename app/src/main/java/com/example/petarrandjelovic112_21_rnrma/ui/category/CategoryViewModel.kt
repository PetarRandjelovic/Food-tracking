package com.example.petarrandjelovic112_21_rnrma.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petarrandjelovic112_21_rnrma.data.repository.CategoryRepository
import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class CategoryViewModel( private val categoryRepository: CategoryRepository) : ViewModel(),
    MainContract.CategoryViewModel {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    override val categories: MutableLiveData<List<Category>> = MutableLiveData()
    override val category: MutableLiveData<Category> = MutableLiveData()

    private val categoriesD = CompositeDisposable()

    override fun getCategories() {
        val category = categoryRepository
            .getAllCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    categories.value = it

                },
                {
                    Timber.e(it)
                },
                {
                    Timber.e("Completed")
                }
            )
        categoriesD.add(category)
    }


}