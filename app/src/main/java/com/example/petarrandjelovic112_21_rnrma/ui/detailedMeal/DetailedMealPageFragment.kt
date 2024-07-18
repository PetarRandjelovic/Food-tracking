package com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.DetailedMealAdapter
import com.example.petarrandjelovic112_21_rnrma.adapter.MealAdapter
import com.example.petarrandjelovic112_21_rnrma.model.MojSingleton
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealPageFragment
import kotlinx.coroutines.NonDisposableHandle.parent
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailedMealPageFragment(private val id: Int) : Fragment(R.layout.fragment_detailed_meal){

    private val detailedMealModel: MainContract.DetailedMealModel by viewModel<DetailedMealModel>()

    var adapter: DetailedMealAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        super.onViewCreated(view, savedInstanceState)




        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val imageViewMeal: ImageView = view.findViewById(R.id.imageViewMeal)
        val textViewCategory: TextView = view.findViewById(R.id.textViewCategory)
        val textViewInstructions: TextView = view.findViewById(R.id.textViewInstructions)
        val textViewURL: TextView = view.findViewById(R.id.textViewURL)
        val textViewArea: TextView = view.findViewById(R.id.textViewArea)
        val textViewTag: TextView = view.findViewById(R.id.textViewTag)
        val button: Button = view.findViewById(R.id.button)

        detailedMealModel.getMeal(id.toString())



        Handler(Looper.getMainLooper()).postDelayed({

            button.setOnClickListener{
                val fragment = SaveMealPageFragment(detailedMealModel.meals.value?.get(0)?.idMeal)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()

            }




            textViewName.text=detailedMealModel.meals.value?.get(0)?.strMeal
            textViewCategory.text=detailedMealModel.meals.value?.get(0)?.strCategory
            textViewInstructions.text=detailedMealModel.meals.value?.get(0)?.strInstructions
            textViewURL.text=detailedMealModel.meals.value?.get(0)?.strYoutube
            textViewArea.text=detailedMealModel.meals.value?.get(0)?.strArea
            textViewTag.text=detailedMealModel.meals.value?.get(0)?.strTags


            Glide.with(imageViewMeal.context)
                .load(detailedMealModel.meals.value?.get(0)?.strMealThumb)
                .into(imageViewMeal)

        },150)



    }



}