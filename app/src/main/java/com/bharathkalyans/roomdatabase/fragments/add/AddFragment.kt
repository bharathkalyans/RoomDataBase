package com.bharathkalyans.roomdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bharathkalyans.roomdatabase.R
import com.bharathkalyans.roomdatabase.model.User
import com.bharathkalyans.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {

        val firstName = firstName_et.text.toString()
        val lastName = lastName_et.text.toString()
        val age = age_et.text


        if (inputCheck(firstName, lastName, age)) {
            //Create User Object
            val user = User(
                id = 0,
                firstName = firstName,
                lastName = lastName,
                age = Integer.parseInt(age.toString())
            )
            //Add data to the DataBase.

            mUserViewModel.addUser(user)

            Toast.makeText(requireContext(), "Successfully Added a User!", Toast.LENGTH_SHORT)
                .show()

            //Navigate Back to the Home Screen(First Fragment)

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Enter Correct Values!!", Toast.LENGTH_SHORT).show()

        }


    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {

        return !(TextUtils.isEmpty(firstName) &&
                TextUtils.isEmpty(lastName) &&
                age.isEmpty()
                )
    }

}