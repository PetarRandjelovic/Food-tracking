package com.example.petarrandjelovic112_21_rnrma.ui.filterPage

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.AreaAdapter
import com.example.petarrandjelovic112_21_rnrma.adapter.CategoryAdapter
import com.example.petarrandjelovic112_21_rnrma.adapter.IngredientsAdapter
import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.google.android.material.tabs.TabLayout

class FilterPageFragment(private val dayMeal: String?): Fragment(R.layout.fragment_filter_page) {

    private val filterViewModel: MainContract.FilterViewModel by viewModel <FilterViewModel>()
    private lateinit var tabLayout: TabLayout
    private lateinit var immageBtn: ImageButton
    private lateinit var mealBtn: ImageButton
    private lateinit var searchView: SearchView


    private var totalPages = 1
    private var isLoading = false
    private var currentPage = 1
    private val itemsPerPage = 20
    private var isOn = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recyclerView: RecyclerView =view.findViewById(R.id.item_list)
        tabLayout = view.findViewById(R.id.tabLayout)
         searchView= view.findViewById(R.id.searchView)

        super.onViewCreated(view, savedInstanceState)

        immageBtn=view.findViewById(R.id.imageButton);


        filterViewModel.getCategories()
        filterViewModel.getAreas()
        filterViewModel.getIngredients()



/*
            val fragment = MealsPageFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.addToBackStack(null) // Add to back stack to enable back navigation
            fragmentTransaction.commit()*/






        filterViewModel.categories.observe(viewLifecycleOwner){
            recyclerView.adapter= CategoryAdapter(it,dayMeal)
        }







        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // Perform actions when a tab is selected
                val position = tab.position



                if(position==0){
                   // filterViewModel.getCategories()
                    filterViewModel.categories.observe(viewLifecycleOwner){
                        recyclerView.adapter= CategoryAdapter(it,dayMeal)

                        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                            android.widget.SearchView.OnQueryTextListener {
                            override fun onQueryTextSubmit(query: String): Boolean {
                                val filterList= filterList(query)
                                return true
                            }

                            override fun onQueryTextChange(newText: String): Boolean {
                                // Perform search or filtering based on the updated query text
                                // performSearch(newText)

                                val filterList= filterListCategory(newText).toList()
                                recyclerView.adapter= CategoryAdapter(filterList,dayMeal)


                                return true
                            }
                        })


                        val sortedList=it.sortedBy { it.getStr() }

                        immageBtn.setOnClickListener {

                            recyclerView.adapter= CategoryAdapter(sortedList,dayMeal)
                        }


                    }
                }else if(position==1){
                    filterViewModel.areas.observe(viewLifecycleOwner){

                        //search(it)

                        recyclerView.adapter= AreaAdapter(it,dayMeal)
                        val sortedList=it.sortedBy { it.getStrArea() }

                        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                            android.widget.SearchView.OnQueryTextListener {
                            override fun onQueryTextSubmit(query: String): Boolean {
                                val filterList= filterList(query)
                                return true
                            }

                            override fun onQueryTextChange(newText: String): Boolean {
                                // Perform search or filtering based on the updated query text
                                // performSearch(newText)

                                val filterList= filterList(newText).toList()
                                recyclerView.adapter= AreaAdapter(filterList,dayMeal)


                                return true
                            }
                        })

                        immageBtn.setOnClickListener {

                            recyclerView.adapter= AreaAdapter(sortedList,dayMeal)

                        }


                    }
                }else {

                    filterViewModel.ingredients.observe(viewLifecycleOwner){

                        recyclerView.adapter= IngredientsAdapter(it,dayMeal)
                        val sortedList=it.sortedBy { it.getStrIngredient() }

                        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                            android.widget.SearchView.OnQueryTextListener {
                            override fun onQueryTextSubmit(query: String): Boolean {
                                val filterList= filterList(query)
                                return true
                            }

                            override fun onQueryTextChange(newText: String): Boolean {
                                // Perform search or filtering based on the updated query text
                                // performSearch(newText)

                                val filterList= filterListIngredient(newText).toList()
                                recyclerView.adapter= IngredientsAdapter(filterList,dayMeal)


                                return true
                            }
                        })
                        immageBtn.setOnClickListener {


                            recyclerView.adapter= IngredientsAdapter(sortedList,dayMeal)

                        }

                    }
                }

                // ...
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Perform actions when a tab is unselected
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Perform actions when a tab is reselected
            }
        })




        recyclerView.layoutManager = LinearLayoutManager(view.context)
      //  recyclerView.layoutManager = LinearLayoutManager(requireContext())



    }




    private fun filterList(query: String): MutableList<Area> {

        val list: List<Area>? =filterViewModel.areas.value


        val areas : MutableList<Area>
        areas= list!!.toMutableList()

        if (areas != null) {
            areas.clear()

            if (query.isEmpty()) {
                filterViewModel.areas.value?.let { areas.addAll(it) }

            } else {
                val lowercaseQuery = query.toLowerCase()
                filterViewModel.areas.value?.let {
                    areas.addAll(it.filter { filter ->
                        filter.getStrArea()?.toLowerCase()!!.contains(lowercaseQuery)
                    })
                }
            }

        }


        return areas;
    }

    private fun filterListCategory(query: String): MutableList<com.example.petarrandjelovic112_21_rnrma.model.Category> {

        val list: List<com.example.petarrandjelovic112_21_rnrma.model.Category>? =filterViewModel.categories.value


        val areas : MutableList<com.example.petarrandjelovic112_21_rnrma.model.Category>
        areas= list!!.toMutableList()

        if (areas != null) {
            areas.clear()

            if (query.isEmpty()) {
                filterViewModel.categories.value?.let { areas.addAll(it) }

            } else {
                val lowercaseQuery = query.toLowerCase()
                filterViewModel.categories.value?.let {
                    areas.addAll(it.filter { filter ->
                        filter.getStr()?.toLowerCase()!!.contains(lowercaseQuery)
                    })
                }
            }

        }



        return areas;
    }


    private fun filterListIngredient(query: String): MutableList<Ingredients> {

        val list: List<Ingredients>? =filterViewModel.ingredients.value


        val areas : MutableList<Ingredients>
        areas= list!!.toMutableList()

        if (areas != null) {
            areas.clear()

            if (query.isEmpty()) {
                filterViewModel.ingredients.value?.let { areas.addAll(it) }

            } else {
                val lowercaseQuery = query.toLowerCase()
                filterViewModel.ingredients.value?.let {
                    areas.addAll(it.filter { filter ->
                        filter.getStrIngredient()?.toLowerCase()!!.contains(lowercaseQuery)
                    })
                }
            }

        }



        return areas;
    }


}