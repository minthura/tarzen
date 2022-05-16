package tech.min.tarzen.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.min.tarzen.data.model.User
import tech.min.tarzen.databinding.UserListItemBinding
import tech.min.tarzen.ui.dialog.TarzenDialog

class UserRecyclerViewAdapter(private val users: List<User>): RecyclerView.Adapter<UserRecyclerViewAdapter.UserItemViewHolder>() {

    class UserItemViewHolder(private val binding: UserListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User){
            binding.user = user
            binding.root.setOnClickListener {
                TarzenDialog.showDialog(binding.root.context, user.name, user.email)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = UserListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

}
