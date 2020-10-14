package com.github.farzadfarazmand.kidzydemo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.farzadfarazmand.kidzydemo.databinding.RowUsersListBinding
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.util.loadCircleImage

class UsersListAdapter(items: MutableList<UserModel>) :
    BaseRecyclerAdapter<UserModel, UsersListAdapter.UserViewHolder>(items) {

    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        if (!::inflater.isInitialized)
            inflater = LayoutInflater.from(parent.context)

        return UserViewHolder(RowUsersListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class UserViewHolder(private val binding: RowUsersListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserModel) {

            binding.user = user
            binding.executePendingBindings()
            binding.userAvatar.loadCircleImage(user.avatar)

        }

    }

}