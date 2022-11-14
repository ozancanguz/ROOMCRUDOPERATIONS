package com.ozancanguz.roomcrudoperations.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ozancanguz.roomcrudoperations.R
import com.ozancanguz.roomcrudoperations.data.User
import com.ozancanguz.roomcrudoperations.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment() {

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(UserViewModel::class.java)

           addBtn.setOnClickListener {
               insertToDatabase()
           }


    }

    private fun insertToDatabase() {
        val firsName=firstnametext.text.toString()
        val lastName=lastnameText.text.toString()
       val age=agetxt.text.toString()

        val user= User(0,firsName,lastName,age)
        viewModel.addUser(user)
        Toast.makeText(requireContext(),"User added database",Toast.LENGTH_LONG)
            .show()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)

    }


}