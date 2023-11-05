package com.example.viewsandwidets.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewsandwidets.R
import com.example.viewsandwidets.databinding.FragmentRailwayRecyclerViewBinding

class RailwayRecyclerViewFragment : Fragment() {
    private var _binding: FragmentRailwayRecyclerViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerViewAdapter: RailwayUsersRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRailwayRecyclerViewBinding.inflate(inflater, container, false)
       // val view = binding.root
        val railwayUsersList = ArrayList<RailwayUsers>()
        railwayUsersList.add(RailwayUsers("pranay", 1, "pra@gmail.com", "pranay prnay"))
        railwayUsersList.add(RailwayUsers("jhon", 2, "jhon@gmail.com", "jhon jhon"))
        railwayUsersList.add(RailwayUsers("cena", 3, "cena@gmail.com", "cena cena"))
        railwayUsersList.add(RailwayUsers("brock", 4, "brock@gmail.com", "brock brock"))
        railwayUsersList.add(RailwayUsers("stone", 5, "stone@gmail.com", "stone stone"))
        railwayUsersList.add(RailwayUsers("orton", 6, "orton@gmail.com", "orton orton"))
        recyclerViewAdapter = RailwayUsersRecyclerViewAdapter(railwayUsersList)
        binding.railwayUserList.adapter = recyclerViewAdapter
        binding.railwayUserList.layoutManager = LinearLayoutManager(requireContext())


  /*      //way 2 to bind recycler view with fragment
        val customAdapter = RailwayUsersRecyclerViewAdapter(railwayUsersList)
        val recyclerView: RecyclerView = binding.railwayUserList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = customAdapter*/

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}