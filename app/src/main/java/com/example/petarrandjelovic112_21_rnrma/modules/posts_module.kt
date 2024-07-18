package com.example.petarrandjelovic112_21_rnrma.modules

import com.example.petarrandjelovic112_21_rnrma.data.database.MainDatabase
import com.example.petarrandjelovic112_21_rnrma.data.datasource.MainDataSource
import com.example.petarrandjelovic112_21_rnrma.data.models.api.IngredientResponse
import com.example.petarrandjelovic112_21_rnrma.data.repository.AreaRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.AreaRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.CategoryRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.CategoryRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.IngredientsRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.IngredientsRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealDetailsRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealDetailsRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealRepository
import com.example.petarrandjelovic112_21_rnrma.data.repository.MealRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.SaveMealRepositoryImpl
import com.example.petarrandjelovic112_21_rnrma.data.repository.SavedMealRepository
import com.example.petarrandjelovic112_21_rnrma.ui.category.CategoryViewModel
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealModel
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterViewModel
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsViewModel
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealModel
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealPageFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val postsModule = module {



    viewModel { FilterViewModel(ingredientRepository = get(),areaRepository = get(),categoryRepository = get()) }

    single<IngredientsRepository> { IngredientsRepositoryImpl(mainDataSource = get()) }

    single<AreaRepository> { AreaRepositoryImpl(mainDataSource = get()) }




    viewModel { CategoryViewModel(categoryRepository = get()) }

    single<CategoryRepository> { CategoryRepositoryImpl(mainDataSource = get()) }



    viewModel { MealsViewModel(mealRepository = get()) }

    single<MealRepository> { MealRepositoryImpl(mainDataSource = get()) }



    viewModel { DetailedMealModel(mealDetailsRepository = get()) }

    single<MealDetailsRepository> { MealDetailsRepositoryImpl(mainDataSource = get()) }

    single<MainDataSource> { create(get()) }


    viewModel { SaveMealModel(get()) }

    single<SavedMealRepository> { SaveMealRepositoryImpl(get()) }

    single { get<MainDatabase>().getSavedMealDao() }


}