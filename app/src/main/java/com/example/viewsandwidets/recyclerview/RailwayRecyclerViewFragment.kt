package com.example.viewsandwidets.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewsandwidets.databinding.FragmentRailwayRecyclerViewBinding

class RailwayRecyclerViewFragment : Fragment(), RemoveButtonListenerInterface,
    CheckBoxCheckListener {
    private var _binding: FragmentRailwayRecyclerViewBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerViewAdapter: RailwayUsersRecyclerViewAdapter

    private var railwayUsersList = ArrayList<RailwayUsers>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRailwayRecyclerViewBinding.inflate(inflater, container, false)
        // val view = binding.root
        // var railwayUsersList = ArrayList<RailwayUsers>()
        railwayUsersList.add(RailwayUsers("pranay", 1, "pra@gmail.com", "pranay prnay"))
        railwayUsersList.add(RailwayUsers("jhon", 2, "jhon@gmail.com", "jhon jhon"))
        railwayUsersList.add(RailwayUsers("cena", 3, "cena@gmail.com", "cena cena"))
        railwayUsersList.add(RailwayUsers("brock", 4, "brock@gmail.com", "brock brock"))
        railwayUsersList.add(RailwayUsers("stone", 5, "stone@gmail.com", "stone stone"))
        railwayUsersList.add(RailwayUsers("orton", 6, "orton@gmail.com", "orton orton"))


        // with two constructor
        recyclerViewAdapter = RailwayUsersRecyclerViewAdapter(requireContext(), railwayUsersList)

        // with three constructor
        recyclerViewAdapter = RailwayUsersRecyclerViewAdapter(requireContext(), railwayUsersList, this)

        // with four constructor
        recyclerViewAdapter = RailwayUsersRecyclerViewAdapter(requireContext(), railwayUsersList, this,this)


        //here we are passing this and implementing its method with name removeButtonClicked
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

    override fun removeButtonClicked(view: View, position: Int) {
        Toast.makeText(requireContext(), "Item Removed $position", Toast.LENGTH_SHORT).show()
        if (position in 0 until railwayUsersList.size) {
            railwayUsersList.removeAt(position)
            recyclerViewAdapter.notifyDataSetChanged()
        }
    }

    override fun itemChecked(view: View, isChecked: Boolean, position: Int) {
        Toast.makeText(requireContext(), "Item check $position  $isChecked", Toast.LENGTH_SHORT)
            .show()
    }

}