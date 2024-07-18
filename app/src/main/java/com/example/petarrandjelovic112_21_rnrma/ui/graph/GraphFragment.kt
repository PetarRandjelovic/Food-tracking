package com.example.petarrandjelovic112_21_rnrma.ui.graph

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import com.example.petarrandjelovic112_21_rnrma.ui.saveMeal.SaveMealModel
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieDataSet
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieEntry
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Calendar
import java.util.Date
import java.util.Locale

class GraphFragment : Fragment(R.layout.piechart){

    private val saveMealModel: MainContract.SaveMealModel by viewModel<SaveMealModel>()
    private lateinit var pieChart: PieChart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        pieChart = view.findViewById(R.id.pieChart)
        super.onViewCreated(view, savedInstanceState)

        saveMealModel.getMealFromLast7Days()
        var entry:  Entry
        val entries = ArrayList<PieEntry>()
        saveMealModel.savedMealsCount.observe(viewLifecycleOwner){

            for(item in it ){

                if (item!=null) {
//"${item.formatted_date}: ${item.meals_count}"
                entries.add(PieEntry(item.meals_count.toFloat(), method(item.formatted_date)))
            }
                }

            println(entries)

            val dataSet = PieDataSet(entries, "Days")
            val data=PieData(dataSet)
            data.setValueTextSize(20f)


            pieChart.data = data
            pieChart.setDrawEntryLabels(false)
            pieChart.description.isEnabled = false
            pieChart.legend.isEnabled = true
            pieChart.setEntryLabelColor(Color.WHITE)
            pieChart.animateY(1000)
            pieChart.invalidate()
        }



    }

    private fun method(date: String): Float {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        println()



        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val daysBetween = calculateDaysBetweenDates(date, currentDate.format(formatter))

        return daysBetween.toFloat()


    }
    fun calculateDaysBetweenDates(date1: String, date2: String): Long {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val localDate1 = LocalDate.parse(date1, formatter)
        val localDate2 = LocalDate.parse(date2, formatter)
        return ChronoUnit.DAYS.between(localDate1, localDate2)
    }

}