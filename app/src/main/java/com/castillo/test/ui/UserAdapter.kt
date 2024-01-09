package com.castillo.test.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.castillo.test.R
import com.castillo.test.data.entities.local.entities.User
import com.castillo.test.data.network.entities.jikan.top.Data
import com.castillo.test.databinding.UserItemsBinding


class UserAdapter (val listUsers : List<Data>) : RecyclerView.Adapter<UserAdapter.UserVH> (){
    class UserVH (view: View) : RecyclerView.ViewHolder (view) {
        private var binding : UserItemsBinding = UserItemsBinding.bind(view)
        fun render (item: Data){
            binding.textID.text = item.mal_id.toString()
            binding.textName.text = item.title_english
            binding.imgUser.load(item.images.jpg.small_image_url){
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