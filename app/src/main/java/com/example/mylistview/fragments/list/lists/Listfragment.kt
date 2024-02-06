package com.example.mylistview.fragments.list.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistview.R
import com.example.mylistview.data.User
import com.example.mylistview.viewmodel.ViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton



class listfragment : Fragment() {

    private lateinit var mUserViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_listfragment, container, false)
        val fabButton: FloatingActionButton = view.findViewById(R.id.floatingActionButton)

        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user: List<User> ->
            adapter.setData(user)
        })

        fabButton.setOnClickListener {
            findNavController().navigate(R.id.action_listfragment_to_addfragment)
        }

        return view
    }
}
