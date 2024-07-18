package com.example.petarrandjelovic112_21_rnrma.ui.meals

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ToggleButton
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.MealAdapter
import com.example.petarrandjelovic112_21_rnrma.data.converters.MealConverter
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MealsPageFragment(private val ids: String?,private val type: String?,private val dayMeal: String?) : Fragment(R.layout.fragment_meals_page) {

    private val mealsViewModel: MainContract.MealsViewModel by viewModel<MealsViewModel>()
    private lateinit var searchView: SearchView
    private val saveMealModel: MainContract.SaveMealModel by viewModel<SaveMealModel>()
    private lateinit var toggleButton: ToggleButton
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recyclerView: RecyclerView =view.findViewById(R.id.item_list)





        searchView= view.findViewById(R.id.searchView)

        if(type.equals("Category")){
            mealsViewModel.getMeals(ids!!)
        }
        else     if(type.equals("Area")) {
            mealsViewModel.getMealsByArea(ids!!)
        }
        else        if(type.equals("Ingredients")) {
            mealsViewModel.getMealsByIngredients(ids!!)
        }
        saveMealModel.getAllSavedMeals()
    //    mealsViewModel.getMealsByIngredients(ids!!)
        toggleButton= view.findViewById(R.id.toggleButton)


        super.onViewCreated(view, savedInstanceState)

        unSavedRecipe(recyclerView)


        toggleButton.setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked) {
                Handler(Looper.getMainLooper()).postDelayed({
                    saveMealModel.meals.observe(viewLifecycleOwner){

                        val mealList = mutableListOf<Meal>()

                        for(item in it ){

                            mealList.add(MealConverter.toMealFromMealSave(item)!!)
                        }

                    if(dayMeal!=null)
                        recyclerView.adapter= MealAdapter(mealList.toList(),3,dayMeal)
                        else
                        recyclerView.adapter= MealAdapter(mealList.toList(),1,dayMeal)
                    }
                    recyclerView.layoutManager = LinearLayoutManager(view.context)
                },150)



            } else {
                unSavedRecipe(recyclerView)

            }
        }


    }


    private fun unSavedRecipe( recyclerView: RecyclerView)  {

        Handler(Looper.getMainLooper()).postDelayed({
            mealsViewModel.meals.observe(viewLifecycleOwner){

                if(dayMeal!=null)
                    recyclerView.adapter= MealAdapter(it,3,dayMeal)
                else
                recyclerView.adapter= MealAdapter(it,2,dayMeal)


                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                    android.widget.SearchView.OnQueryTextListener {


                    override fun onQueryTextSubmit(query: String): Boolean {
                        val filterList= filterList(query)



                        mealsViewModel.getMealsByIngredients(query)
                        if(dayMeal!=null)
                            recyclerView.adapter= MealAdapter(it,3,dayMeal)
                        else
                        recyclerView.adapter= MealAdapter(it,2,dayMeal)

                        return true
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        // Perform search or filtering based on the updated query text
                        // performSearch(newText)

                        //val filterList= filterList(newText).toList()
                        mealsViewModel.getMealsByName(newText)

                        if(dayMeal!=null)
                            recyclerView.adapter= MealAdapter(it,3,dayMeal)
                        else
                        recyclerView.adapter= MealAdapter(it,2,dayMeal)


                        return true
                    }
                })

            }

            recyclerView.layoutManager = LinearLayoutManager(requireView().context)
        },150)



    }
    private fun filterList(query: String): MutableList<Meal> {

        val list: List<Meal>? =mealsViewModel.meals.value


        val areas : MutableList<Meal>
        areas= list!!.toMutableList()

        if (areas != null) {
            areas.clear()

            if (query.isEmpty()) {
                mealsViewModel.meals.value?.let { areas.addAll(it) }

            } else {
                val lowercaseQuery = query.toLowerCase()
                mealsViewModel.meals.value?.let {
                    areas.addAll(it.filter { filter ->
                        filter.strMeal?.toLowerCase()!!.contains(lowercaseQuery)
                    })
                }
            }

        }

        //   println(areas.get(0).getStrArea())
        //  println("LOL")

        return areas;
    }

}