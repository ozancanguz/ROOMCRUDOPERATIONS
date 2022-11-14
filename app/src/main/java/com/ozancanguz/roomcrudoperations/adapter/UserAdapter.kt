package com.ozancanguz.roomcrudoperations.adapter

import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.Person.fromBundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.roomcrudoperations.R
import com.ozancanguz.roomcrudoperations.data.User
import com.ozancanguz.roomcrudoperations.ui.ListFragmentDirections
import kotlinx.android.synthetic.main.item_layout.view.*

class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var userList= emptyList<User>()


    fun setData(user:List<User>){
         this.userList=user
        notifyDataSetChanged()

    }

    class UserViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.firstnametext.text=userList[position].firstName
        holder.itemView.lastnameText.text=userList[position].lastName
        holder.itemView.agetxt.text=userList[position].age
        holder.itemView.idtxt.text=userList[position].id.toString()


           holder.itemView.rowlayout.setOnClickListener {

               val args = ListFragmentDirections.actionListFragmentToUpdateFragment(currenUser)


               holder.itemView.findNavController().navigate(action)

           }

    }

    override fun getItemCount(): Int {
       return userList.size
    }


}