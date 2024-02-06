package com.example.mylistview.fragments.list.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mylistview.R
import com.example.mylistview.data.User
import com.example.mylistview.viewmodel.ViewModel


class addfragment : Fragment() {

    private lateinit var mUserViewModel: ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_addfragment, container, false)

        mUserViewModel = ViewModelProvider(this)[ViewModel::class.java]

        val add_btn: Button = view.findViewById(R.id.button)

        add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName = view?.findViewById<EditText>(R.id.editTextText)?.text.toString()
        val lastName = view?.findViewById<EditText>(R.id.editTextText2)?.text.toString()
        val age = view?.findViewById<EditText>(R.id.editTextText3)?.text.toString()

        if( age?.let { inputCheck(firstName, lastName, it) } == true){
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addfragment_to_listfragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}