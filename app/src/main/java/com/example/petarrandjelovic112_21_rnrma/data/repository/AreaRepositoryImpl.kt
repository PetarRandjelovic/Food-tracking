package com.example.petarrandjelovic112_21_rnrma.data.repository

import com.example.petarrandjelovic112_21_rnrma.data.datasource.MainDataSource
import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.Category
import io.reactivex.Observable

class AreaRepositoryImpl (private val mainDataSource: MainDataSource) :AreaRepository {



    override fun getAllAreas(): Observable<List<Area>> {
        return mainDataSource
            .getAllAreas()
            .map {
                it.meals.map { areaResponse ->
                    Area(


                        strArea = areaResponse.strArea!!,

                    )
                }
            }
    }
}