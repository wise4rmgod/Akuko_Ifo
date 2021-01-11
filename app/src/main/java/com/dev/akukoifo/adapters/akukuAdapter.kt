package com.dev.akukoifo.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dev.akukoifo.R
import com.dev.akukoifo.databinding.DesignlistBinding
import com.dev.akukoifo.databinding.FragmentHomeBinding
import com.dev.akukoifo.model.AkukoDataClass
import com.dev.akukoifo.ui.DetailsView.DetailsViewFragment

class akukuAdapter(
    private var dataList: ArrayList<AkukoDataClass>,
    private val context: Context
) :
    RecyclerView.Adapter<akukuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DesignlistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(
            binding
        )

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.titleTextView.text = dataModel.title
        holder.description.text = dataModel.description

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(R.id.action_navigation_home_to_detailsViewFragment)
        }

    }

    class ViewHolder(binding: DesignlistBinding) : RecyclerView.ViewHolder(binding.root) {
        var titleTextView: TextView = binding.cardtitle
        var description: TextView = binding.carddescription
    }


}
