package com.example.city.ui.listofcities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.databinding.FragmentListofcitiesBinding
import com.example.city.ui.MainViewModel
import com.example.city.ui.RecyclerAdapter

class ListOfCitiesFragment: Fragment(R.layout.fragment_listofcities) {
    private lateinit var recyclerView: RecyclerView
    private val viewmodel  by activityViewModels<MainViewModel>()
    lateinit var binding:FragmentListofcitiesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentListofcitiesBinding.bind(view)
        viewmodel.cityList.forEach {
            if (it.favorite==false){
                it.id=Color.WHITE
            }else{
                it.id=Color.BLUE
            }
        }


        recyclerView=view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val adpter=RecyclerAdapter(viewmodel.cityList){
            it.favorite= it.favorite.not()
            if (it.favorite==false){
                it.id=Color.WHITE
            }else{
                it.id=Color.BLUE
            }
            recyclerView.adapter?.notifyDataSetChanged()
        }
        recyclerView.adapter=adpter
        binding.submit.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_listOfCitiesFragment_to_favoriteCitiesFragment)
        }
    }
}