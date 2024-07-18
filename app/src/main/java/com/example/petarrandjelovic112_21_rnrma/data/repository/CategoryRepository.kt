package com.example.petarrandjelovic112_21_rnrma.data.repository

import io.reactivex.Observable
import java.util.Locale.Category

interface CategoryRepository {

    fun getAllCategories(): Observable<List<com.example.petarrandjelovic112_21_rnrma.model.Category>>

}