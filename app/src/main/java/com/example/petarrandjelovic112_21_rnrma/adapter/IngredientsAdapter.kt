package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.model.Ingredients
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterViewHolder
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsPageFragment

class IngredientsAdapter(private val mList: List<Ingredients>?,private val dayMeal: String?) : RecyclerView.Adapter<FilterViewHolder>()  {


    private lateinit var parent: ViewGroup;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        this.parent = parent;
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return FilterViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mList != null)
            return mList.size
        return 0;
    }



    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val ingredients = mList?.get(position)

        if (ingredients != null) {
            holder.name.text = ingredients.getStrIngredient()

            holder.imageButton.setOnClickListener {


                val fragment = MealsPageFragment(ingredients.getStrIngredient(),"Ingredients",dayMeal) // Create an instance of the new fragment
                val fragmentManager = (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }
        }

    }
}