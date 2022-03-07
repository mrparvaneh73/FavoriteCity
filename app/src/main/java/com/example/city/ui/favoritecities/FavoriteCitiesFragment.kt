package com.example.city.ui.favoritecities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.SwipGesture
import com.example.city.databinding.FragmentFavoritecitiesBinding
import com.example.city.ui.MainViewModel
import com.example.city.ui.RecyclerAdapter

class FavoriteCitiesFragment : Fragment(R.layout.fragment_favoritecities) {
    private lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentFavoritecitiesBinding
    private val viewmodel by activityViewModels<MainViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritecitiesBinding.bind(view)
        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        viewmodel.favorite()
        val adapter = RecyclerAdapter(viewmodel.favorite()) {

        }
        val swipGesture = object : SwipGesture(view.context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        val position = viewHolder.absoluteAdapterPosition
                        viewmodel.favorite()[position].favorite = false
                        recyclerView.adapter?.notifyItemRemoved(position)
                        recyclerView.adapter?.notifyDataSetChanged()

                        adapter.deleteItem(position)


                    }

                }

            }
        }
        val touchHelper = ItemTouchHelper(swipGesture)
        touchHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter
    }
}