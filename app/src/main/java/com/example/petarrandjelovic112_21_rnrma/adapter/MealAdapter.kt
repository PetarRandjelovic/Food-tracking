package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.model.Meal
import com.example.petarrandjelovic112_21_rnrma.model.MojSingleton
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.editMeal.EditMealPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsViewHolder

class MealAdapter(private val mList: List<Meal>?,private val list: Int,private val dayMeal: String?) : RecyclerView.Adapter<MealsViewHolder>()   {

    private lateinit var parent: ViewGroup;

    private lateinit var view: View;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        this.parent = parent;

        if(list==1) {

             view = LayoutInflater.from(parent.context)
                .inflate(R.layout.saveditem_list, parent, false)
        }else if(list==2){
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        }else if(list==3){
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.planitem_list, parent, false)
        }




        return MealsViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (mList != null)
            return mList.size
        return 0;
    }



    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val meals = mList?.get(position)


        if (meals != null) {
            holder.name.text = meals.strMeal
            Glide.with(holder.imageView.context)
                .load(meals.strMealThumb)
                .into(holder.imageView)

            holder.imageButton.setOnClickListener {


                val fragment = DetailedMealPageFragment(meals.idMeal) // Create an instance of the new fragment
                val fragmentManager = (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }
if(list==1) {
    holder.imageButtonEdit.setOnClickListener {

        val fragment = EditMealPageFragment(meals.idMeal) // Create an instance of the new fragment
        val fragmentManager = (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }


}
            if(list==3){
                holder.imageButtonAdd.setOnClickListener(){

                   // println("TEST")
                //    println(MojSingleton.dayMealsList.value)

                    MojSingleton.dayMealsList.value?.let { currentList ->
                        val updatedList = currentList.toMutableList()
                        updatedList.add(DayMeal(meals, dayMeal))
                        MojSingleton.dayMealsList.value = updatedList

                   //     println("EJJJ")
                    //    println(MojSingleton.dayMealsList.value)
                    } ?: run {
                        // Code to handle the case when MojSingleton.dayMealsList.value is null
                        // For example, you can create a new list and assign it to the singleton's value
                        val newList = mutableListOf(DayMeal(meals, dayMeal))
                        MojSingleton.dayMealsList.value = newList
                    }



                }

            }

        }

    }
}