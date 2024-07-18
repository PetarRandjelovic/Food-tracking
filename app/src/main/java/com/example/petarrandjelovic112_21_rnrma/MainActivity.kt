package com.example.petarrandjelovic112_21_rnrma

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petarrandjelovic112_21_rnrma.ui.category.CategoryFragment
import com.example.petarrandjelovic112_21_rnrma.ui.filterPage.FilterPageFragment
import com.example.petarrandjelovic112_21_rnrma.ui.graph.GraphFragment
import com.example.petarrandjelovic112_21_rnrma.ui.plan.PlanPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


    }

    private fun init() {
     //   var recyclerView:RecyclerView=view.findViewById(R.id.listCatego
        //   ry)
bottomNavigationView=findViewById(R.id.bottomNavigationView)
Timber.e(bottomNavigationView.toString())
       // createFragment()
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.categoryViewID -> {
                    createFragment()
                    println("POZDRAV")
                    true
                }

                R.id.filterViewID -> {

                    createFragmentFilter()


                    true
                }

                R.id.profilID -> {
                    createFragmentPieChart()

                    true
                }
                R.id.planID -> {
                    createFragmentPlan()

                    true
                }

                else -> false
            }
        }


    }
    fun createFragment() {
        val fragment = CategoryFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
    fun createFragmentFilter() {
        val fragment = FilterPageFragment(null)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
    fun createFragmentPieChart() {
        val fragment = GraphFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
    fun createFragmentPlan() {
        val fragment = PlanPageFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }


}