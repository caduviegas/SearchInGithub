package com.innaval.searchingithub.presentation.user.info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.innaval.searchingithub.databinding.ItemUserInfoBinding
import com.innaval.searchingithub.domain.model.UserInformationsModel

class UserInfoAdapter() :
    ListAdapter<UserInformationsModel, UserInfoAdapter.UserInfoViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserInfoViewHolder {
        return UserInfoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int) = position

    class UserInfoViewHolder(
        private val itemBinding:ItemUserInfoBinding,
    ): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(userInformationsModel: UserInformationsModel){
            itemBinding.run {
                userInfoName.text = userInformationsModel.name
                userInfoLang.text = userInformationsModel.language
                userInfoWatchersCount.text = "${userInformationsModel.watchersCount}"
                userInfoForksCount.text = "${userInformationsModel.forksCount}"
                userInfoStarsCount.text = "${userInformationsModel.stargazersCount}"
            }
        }
        companion object {
            fun create(parent: ViewGroup): UserInfoViewHolder {
                val itemBinding = ItemUserInfoBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return UserInfoViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserInformationsModel>() {
            override fun areItemsTheSame(
                oldItem: UserInformationsModel,
                newItem: UserInformationsModel,
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: UserInformationsModel,
                newItem: UserInformationsModel,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}