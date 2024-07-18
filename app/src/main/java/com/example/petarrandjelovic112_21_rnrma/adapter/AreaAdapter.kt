package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.Area
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterViewHolder
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsPageFragment

class AreaAdapter(private val mList: List<Area>?,private val dayMeal: String?) : RecyclerView.Adapter<FilterViewHolder>()   {

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
        val areas = mList?.get(position)





        if (areas != null) {
            holder.name.text = areas.getStrArea()

            holder.imageButton.setOnClickListener {


                val fragment = MealsPageFragment(areas.getStrArea(),"Area",dayMeal) // Create an instance of the new fragment
                val fragmentManager = (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }


        }

    }





}