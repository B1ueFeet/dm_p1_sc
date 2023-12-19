package com.castillo.test.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.castillo.test.R
import com.castillo.test.data.entities.entities.User
import com.castillo.test.databinding.UserItemsBinding


class UserAdapter (val listUsers : List<User>) : RecyclerView.Adapter<UserAdapter.UserVH> (){
    class UserVH (view: View) : RecyclerView.ViewHolder (view) {
        private var binding : UserItemsBinding = UserItemsBinding.bind(view)
        fun render (item:User){
            binding.textID.text = item.userId.toString()
            binding.textName.text = item.firstName.toString() + " " + item.lastName.toString()
            binding.imgUser.load("https://cdn-icons-png.flaticon.com/512/1177/1177568.png"){
                crossfade(true)
                placeholder(R.drawable.user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val inflater = LayoutInflater.from(parent.context)
        return UserVH(inflater.inflate(R.layout.user_items, parent,false))
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.render(listUsers[position])
    }
}