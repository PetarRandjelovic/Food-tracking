package com.example.petarrandjelovic112_21_rnrma.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.ui.category.CategoryViewHolder
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsPageFragment

class CategoryAdapter(private val mList: List<Category>?,private val dayMeal: String?) : RecyclerView.Adapter<CategoryViewHolder>() {

    private lateinit var parent: ViewGroup;
   // private var itemClickListener:OnFilterItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder{



        this.parent = parent;
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_list, parent, false)
        val viewHolder = CategoryViewHolder(view)




        return CategoryViewHolder(view)
    }


    override fun getItemCount(): Int {
        if (mList != null)
            return mList.size
        return 0;
    }
    fun setData(categories: List<Category>) {
     //   mList = categories
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = mList?.get(position)



        if (category != null) {

            holder.imageButton.setOnClickListener {


                val fragment = MealsPageFragment(category.getStr(),"Category",dayMeal) // Create an instance of the new fragment
                val fragmentManager = (parent.context as AppCompatActivity).supportFragmentManager // Use parent.context to get the FragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.commit()
            }

            holder.nameCategory.text = category.getStr()


            if (category != null) {
                holder.nameCategory.text = category.getStr()


                Glide.with(holder.imageView.context)
                    .load(category.getPicture())
                    .into(holder.imageView)
            }


           /* holder.itemView.setOnClickListener {

                itemClickListener?.onItemClick(Filter.AREA, area.strArea)
            }*/
        }

    }


}