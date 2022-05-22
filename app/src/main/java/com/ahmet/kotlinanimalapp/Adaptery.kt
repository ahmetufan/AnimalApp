package com.ahmet.kotlinanimalapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmet.kotlinanimalapp.databinding.RowBinding
import com.ahmet.kotlinanimalapp.interfaces.HomeClick
import com.ahmet.kotlinanimalapp.model.Model2
import com.ahmet.kotlinanimalapp.ui.home.HomeFragmentDirections

class Adaptery(val arraList:ArrayList<Model2>, val homeClick: HomeClick) : RecyclerView.Adapter<Adaptery.Holder>() {

    class Holder(val binding:RowBinding) : RecyclerView.ViewHolder (binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptery.Holder {
        val binding=RowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Adaptery.Holder, position: Int) {
        holder.binding.textRow.text=arraList.get(position).hayvan_ismi
       // holder.binding.rowimageView.setImageResource(arraList.get(position).image)



        holder.itemView.setOnClickListener {
            val action=HomeFragmentDirections.actionNavigationHomeToNavigationDashboard(arraList[position].id)
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {

        return arraList.size
    }
    fun updateAnimalList(newAnimalList:List<Model2>) {
        arraList.clear()
        arraList.addAll(newAnimalList)
        notifyDataSetChanged()
    }
}