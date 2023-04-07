package com.twish.vaxify.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.twish.vaxify.app.data.AgeGroupDto
import com.twish.vaxify.databinding.ListVaccinesBinding

class AgeGroupAdapter: RecyclerView.Adapter<AgeGroupAdapter.ViewHolder>() {

    var ageGroupList: List<AgeGroupDto> = emptyList()
    fun updateData(newList: List<AgeGroupDto> ){
        ageGroupList = newList
    }

    class ViewHolder(val listItem: ListVaccinesBinding) : RecyclerView.ViewHolder(listItem.root) {
        fun bind(item: AgeGroupDto) {
            listItem.ageId.text = "Age: " + item.age
            item.vaccines.forEach { vaccine ->
                listItem.tvVaccines.text = vaccine.fullName + ","
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListVaccinesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = ageGroupList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ageGroupList[position])
    }
}