package com.example.petarrandjelovic112_21_rnrma.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.petarrandjelovic112_21_rnrma.R
import com.example.petarrandjelovic112_21_rnrma.adapter.CategoryAdapter
import com.example.petarrandjelovic112_21_rnrma.model.Category
import com.example.petarrandjelovic112_21_rnrma.ui.contract.MainContract
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment : Fragment(R.layout.fragment_category),ImageButtonClickListener {

    private val categoryViewModel: MainContract.CategoryViewModel by viewModel<CategoryViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       var recyclerView:RecyclerView=view.findViewById(R.id.listCategory)
        categoryViewModel.getCategories()

        super.onViewCreated(view, savedInstanceState)




categoryViewModel.categories.observe(viewLifecycleOwner){



    recyclerView.adapter=CategoryAdapter(it,null)

}


        recyclerView.layoutManager = LinearLayoutManager(view.context)


    }

    override fun onImageButtonClick(position: String) {

        println(position)
        println("ZDRAVO")
    }


}