package com.example.homwork3java2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homwork3java2.data.models.User
import com.example.homwork3java2.databinding.ItemUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val users = mutableListOf<User>()
    fun setUsers(users: List<User>){
        this.users.distinctBy { it.id }
        this.users.addAll(users)
    }
    inner class UserViewHolder(private val binding: ItemUserBinding):
            RecyclerView.ViewHolder(binding.root){
                fun onBind(user: User) = with(binding){
                    tvUsername.text = user.name
                    tvAge.text = user.age.toString()
                    tvEmail.text = user.email
                }
            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount() = users.size
}