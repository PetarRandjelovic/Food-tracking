package com.example.petarrandjelovic112_21_rnrma.ui.saveMeal

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.DetailedMealAdapter
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.detailedMeal.DetailedMealModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.app.DatePickerDialog
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.petarrandjelovic112_21_rnrma.data.converters.MealConverter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class SaveMealPageFragment(private val id: String?)  : Fragment(R.layout.fragment_save_meal){

    private val saveMealModel: MainContract.SaveMealModel by viewModel<SaveMealModel>()
    private val detailedMealModel: MainContract.DetailedMealModel by viewModel<DetailedMealModel>()
    var adapter: DetailedMealAdapter? = null
    var selectedItem: String? = null
    var izabraniDatum: String? = null
    private lateinit var buttonDate: Button
    private lateinit var spinner: Spinner
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        super.onViewCreated(view, savedInstanceState)


        val textView: TextView = view.findViewById(R.id.textView)
        val imageView2: ImageView = view.findViewById(R.id.imageView2)
        val textView2: TextView = view.findViewById(R.id.textView2)
         buttonDate = view.findViewById(R.id.buttonDate)
        val buttonSave: Button = view.findViewById(R.id.buttonSave)
        spinner = view.findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.options_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                 selectedItem = parent.getItemAtPosition(position).toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                 selectedItem = "Launch"
            }

        }

        val formattedDate = formatDate(Calendar.getInstance().time)
        buttonDate.text=formattedDate

        detailedMealModel.getMeal(id.toString())

        Handler(Looper.getMainLooper()).postDelayed({

            buttonDate.setOnClickListener {

                showDatePicker()
            }

            buttonSave.setOnClickListener {

               // println(returnDate())
                saveMealModel.instertSavedMeal(MealConverter.fromMeal(detailedMealModel.meals.value?.get(0)!!,selectedItem,Date(returnDate()))!!)

                //   println(saveMealModel.getAllSavedMeals())

            }


            textView.text=detailedMealModel.meals.value?.get(0)?.strMeal


            Glide.with(imageView2.context)
                .load(detailedMealModel.meals.value?.get(0)?.strMealThumb)
                .into(imageView2)

        },150)



    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(requireContext(),
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // Handle the selected date
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDayOfMonth)

                // Do something with the selected date
                val formattedDate = formatDate(selectedDate.time)


                buttonDate.text = formattedDate



            }, year, month, dayOfMonth)

        datePickerDialog.show()


    }

    private fun returnDate(): Long {

        val dateFormat = SimpleDateFormat("MM/dd/yy")
        val date = dateFormat.parse(buttonDate.text.toString())
        val timestamp = date.time

        return timestamp
    }

    private fun formatDate(date: Date): String {
        val dateFormat = android.text.format.DateFormat.getDateFormat(requireContext())
        return dateFormat.format(date)
    }


}