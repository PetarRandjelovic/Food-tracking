package com.example.petarrandjelovic112_21_rnrma.ui.editMeal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.DetailedMealAdapter
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealModel
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.meals.MealsPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealModel
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealPageFragment
import kotlinx.coroutines.NonDisposableHandle.parent
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditMealPageFragment(private val id: Int) : Fragment(R.layout.fragment_edit_meal) {


    private val detailedMealModel: MainContract.DetailedMealModel by viewModel<DetailedMealModel>()
    private val saveMealModel: MainContract.SaveMealModel by viewModel<SaveMealModel>()
    var adapter: DetailedMealAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        super.onViewCreated(view, savedInstanceState)




        val textViewName: EditText = view.findViewById(R.id.textViewName)
        val imageViewMeal: ImageView = view.findViewById(R.id.imageViewMeal)
        val textViewCategory: TextView = view.findViewById(R.id.textViewCategory)
        val textViewInstructions: EditText = view.findViewById(R.id.textViewInstructions)
        val textViewURL: EditText = view.findViewById(R.id.textViewURL)
        val textViewArea: TextView = view.findViewById(R.id.textViewArea)
        val textViewTag: TextView = view.findViewById(R.id.textViewTag)
        val buttonDelete: Button = view.findViewById(R.id.buttonDelete)
        val buttonSave: Button = view.findViewById(R.id.buttonSave)

        detailedMealModel.getMeal(id.toString())

        saveMealModel.getAllSavedMeals()


        Handler(Looper.getMainLooper()).postDelayed({



            buttonDelete.setOnClickListener{

                saveMealModel.deleteMeal(id)
                val fragment = FilterPageFragment(null) // Create an instance of the new fragment
                val fragmentManager = parentFragmentManager // Use parentFragmentManager to get the FragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.addToBackStack(null) // Optional: Add the transaction to the back stack
                fragmentTransaction.commit()
            }

            println("EDIT")
            println(saveMealModel.meals.value?.get(0)?.strMeal)

            textViewName.setText(saveMealModel.meals.value?.get(0)?.strMeal)

            textViewCategory.setText(saveMealModel.meals.value?.get(0)?.strCategory)
            textViewInstructions.setText(saveMealModel.meals.value?.get(0)?.strInstructions)
            textViewURL.setText(saveMealModel.meals.value?.get(0)?.strYoutube)
            textViewArea.setText(saveMealModel.meals.value?.get(0)?.strArea)
            textViewTag.setText(saveMealModel.meals.value?.get(0)?.strTags)


            Glide.with(imageViewMeal.context)
                .load(saveMealModel.meals.value?.get(0)?.strMealThumb)
                .into(imageViewMeal)


            buttonSave.setOnClickListener{


                //strInstructions strYoutube strMeal
                saveMealModel.updateMealById(
                    detailedMealModel.meals.value?.get(0)?.idMeal!!.toLong(),
                    textViewName.text.toString(),
                    textViewURL.text.toString(),
                    textViewInstructions.text.toString()
                )
                println("ULAZIM")
                println(saveMealModel.getAllSavedMeals())


                val fragment = SaveMealPageFragment(detailedMealModel.meals.value?.get(0)?.idMeal)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()

            }
        },150)



    }


}