package com.bharathkalyans.roomdatabase.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.bharathkalyans.roomdatabase.R
import com.bharathkalyans.roomdatabase.model.User
import com.bharathkalyans.roomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.updatefirstName_et.setText(args.currentUser.firstName)
        view.updatelastName_et.setText(args.currentUser.lastName)
        view.updateage_et.setText(args.currentUser.age.toString())


        view.updateButton.setOnClickListener {
            updateItem()
        }

        return view
    }


    private fun updateItem() {
        val firstName = updatefirstName_et.text.toString()
        val lastName = updatelastName_et.text.toString()
        val age = Integer.parseInt(updateage_et.text.toString())


        if (inputCheck(firstName = firstName, lastName = lastName, age = updateage_et.text)) {

            //Updated User
            val updatedUser = User(
                args.currentUser.id, firstName, lastName, age
            )

            //Calling updateUser Co routine function from the User View Model.
            mUserViewModel.updateUser(updatedUser)

            Toast.makeText(requireContext(), "Updated Successfully !", Toast.LENGTH_SHORT).show()
            //Navigate back to List of Users(First Fragment/Home Activity)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Enter Correct Values!🙂", Toast.LENGTH_SHORT).show()

        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) &&
                TextUtils.isEmpty(lastName) &&
                age.isEmpty()
                )
    }


}