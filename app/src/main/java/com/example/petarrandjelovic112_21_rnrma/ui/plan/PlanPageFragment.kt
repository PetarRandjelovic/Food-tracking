package com.example.petarrandjelovic112_21_rnrma.ui.plan

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.model.DayMeal
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.mealDay.MealDayPageFragment

class PlanPageFragment() : Fragment(R.layout.fragment_create_plan) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val buttonDay1: Button = view.findViewById(R.id.buttonDay1)
        val buttonDay2: Button = view.findViewById(R.id.buttonDay2)
        val buttonDay3: Button = view.findViewById(R.id.buttonDay3)
        val buttonDay4: Button = view.findViewById(R.id.buttonDay4)
        val buttonDay5: Button = view.findViewById(R.id.buttonDay5)
        val buttonDay6: Button = view.findViewById(R.id.buttonDay6)
        val buttonDay7: Button = view.findViewById(R.id.buttonDay7)


        buttonDay1.setOnClickListener {

            val fragment = MealDayPageFragment("Monday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }

        buttonDay2.setOnClickListener {

            val fragment =MealDayPageFragment("Tuesday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }
        buttonDay3.setOnClickListener {

            val fragment = MealDayPageFragment("Wednesday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }

        buttonDay4.setOnClickListener {

            val fragment =MealDayPageFragment("Thursday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        buttonDay5.setOnClickListener {

            val fragment =MealDayPageFragment("Friday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()

        }

        buttonDay6.setOnClickListener {

            val fragment = MealDayPageFragment("Saturday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()


        }
        buttonDay7.setOnClickListener {

            val fragment = MealDayPageFragment("Sunday")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }



    }
}