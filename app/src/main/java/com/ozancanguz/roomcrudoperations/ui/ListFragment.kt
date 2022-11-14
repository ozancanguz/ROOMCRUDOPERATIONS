package com.ozancanguz.roomcrudoperations.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.roomcrudoperations.R
import com.ozancanguz.roomcrudoperations.adapter.UserAdapter
import com.ozancanguz.roomcrudoperations.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {


    lateinit var  viewModel:UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           // init recycleview
        var adapter=UserAdapter()
           recyclerView.adapter=adapter
          recyclerView.layoutManager=LinearLayoutManager(requireContext())

        // init viewmodel
        viewModel= ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->

            adapter.setData(user)


        })

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

    }


    }
