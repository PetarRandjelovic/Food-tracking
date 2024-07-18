package com.example.petarrandjelovic112_21_rnrma.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.petarrandjelovic112_21_rnrma.data.converters.DateConverter
import com.example.petarrandjelovic112_21_rnrma.data.converters.StringListConverter
import com.example.petarrandjelovic112_21_rnrma.data.datasource.SavedMealDao
import com.example.petarrandjelovic112_21_rnrma.model.MealSave


@Database(
    entities = [MealSave::class],
    version = 1,
    exportSchema = false)
@TypeConverters(StringListConverter::class, DateConverter::class)
abstract class MainDatabase : RoomDatabase() {

    abstract fun getSavedMealDao(): SavedMealDao

}