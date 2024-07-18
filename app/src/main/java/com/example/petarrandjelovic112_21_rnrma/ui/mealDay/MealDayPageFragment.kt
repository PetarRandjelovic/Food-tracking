package com.example.petarrandjelovic112_21_rnrma.ui.mealDay

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.MealDayAdapter
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.model.MojSingleton
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsViewModel
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealDayPageFragment(public val s: String) : Fragment(R.layout.fragment_listofcreationplan) {

    private val mealsViewModel: MainContract.MealsViewModel by viewModel<MealsViewModel>()
    private lateinit var searchView: SearchView
    private val saveMealModel: MainContract.SaveMealModel by viewModel<SaveMealModel>()

    val dayMealsList: MutableLiveData<List<DayMeal>> = MutableLiveData()
    private lateinit var buttonAdd: Button
    private val singleton: MojSingleton = MojSingleton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recyclerView: RecyclerView =view.findViewById(R.id.item_list)
        super.onViewCreated(view, savedInstanceState)


        buttonAdd =view.findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener{
            val fragment = FilterPageFragment(s)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }
      //  println("SINGLE")
      //  println(singleton.dayMealsList.value)


        singleton.dayMealsList.observe(viewLifecycleOwner){
            val newDayMealsList = mutableListOf<DayMeal>()

            println("POZZ")
            println(it)
            for(item in it){
            if(item.day.equals(s)){
                newDayMealsList.add(item)
            }
            }

            recyclerView.adapter= MealDayAdapter(newDayMealsList)


        }
        recyclerView.layoutManager = LinearLayoutManager(view.context)


    }
}