package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MealDetails
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealViewHolder
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsViewHolder

class DetailedMealAdapter(private val mList: MealDetails) : RecyclerView.Adapter<DetailedMealViewHolder>()   {

    private lateinit var parent: ViewGroup;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedMealViewHolder {
        this.parent = parent;
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        println(mList)
        println("mList")

        return DetailedMealViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mList != null)
            return 1
        return 0;
    }



    override fun onBindViewHolder(holder: DetailedMealViewHolder, position: Int) {
        val meals = mList

        println(meals!=null)
        if (meals != null) {
            println(meals.idMeal)


            holder.textViewName.text = meals.strMeal




            Glide.with(holder.imageViewMeal.context)
                .load(meals.strMealThumb)
                .into(holder.imageViewMeal)

            holder.button.setOnClickListener {



            }
        }

    }
}