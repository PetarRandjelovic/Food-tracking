package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.data.datasource.MainDataSource
import com.example.petarrandjelovic112_21_rnrma.model.Category
import io.reactivex.Observable


class CategoryRepositoryImpl(private val mainDataSource: MainDataSource) :CategoryRepository {




    override fun getAllCategories(): Observable<List<Category>> {


        return mainDataSource
            .getAllCategories()
            .map {
                it.categories.map { categoryResponse ->
                    Category(


                        id = categoryResponse.idCategory!!,
                        strCategory = categoryResponse.strCategory!!,
                        picture = categoryResponse.strCategoryThumb!!,
                        description = categoryResponse.strCategoryDescription!!,
                    )
                }
            }
    }
}

