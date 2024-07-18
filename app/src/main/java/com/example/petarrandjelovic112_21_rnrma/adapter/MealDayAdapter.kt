package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.mealDay.MealDayPageViewHolder

class MealDayAdapter(private val mList: List<DayMeal>)  : RecyclerView.Adapter<MealDayPageViewHolder>(){

    private lateinit var parent: ViewGroup;

    private lateinit var view: View;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealDayPageViewHolder {
        this.parent = parent;




            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)





        return MealDayPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealDayPageViewHolder, position: Int) {
        val meals = mList?.get(position)

        println("meals")
        println(meals)

        if (meals != null) {

                holder.name.text = meals.meal!!.strMeal
                Glide.with(holder.imageView.context)
                    .load(meals.meal!!.strMealThumb)
                    .into(holder.imageView)

                holder.imageButton.setOnClickListener {


                    val fragment =
                        DetailedMealPageFragment(meals.meal!!.idMeal) // Create an instance of the new fragment
                    val fragmentManager =
                        (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.fragment_container, fragment)
                    fragmentTransaction.commit()
                }



                }
    }

    override fun getItemCount(): Int {



        if (mList != null)
            return mList.size
        return 0;
    }

}