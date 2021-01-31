package com.dev.akukoifo.ui.DetailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.dev.akukoifo.MainActivity
import com.dev.akukoifo.R
import com.dev.akukoifo.databinding.FragmentDetailsViewBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activitytoolbar.view.*


class DetailsViewFragment : Fragment() {

    private lateinit var binding: FragmentDetailsViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentDetailsViewBinding.inflate(inflater, container, false)
        val view = binding.root

        //  binding.toolbar.inflateMenu(R.menu.toolbarmenu)
        activity?.includetoolbar?.atoolbar?.title = "Details"
        activity?.includetoolbar?.atoolbar?.setNavigationIcon(R.drawable.ic_arrow_back)

        //  binding.includetoolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        activity?.includetoolbar?.atoolbar?.setNavigationOnClickListener {
            findNavController()
                .navigate(R.id.action_detailsViewFragment_to_navigation_home)
        }

        /**    binding.toolbar.setOnMenuItemClickListener {
        it
        when (it.itemId) {
        R.id.backbutton -> {
        Toast.makeText(binding.root.context, "click", Toast.LENGTH_SHORT).show()
        true
        }

        else -> {
        true
        }
        }
        }  **/


        binding.playvideo.setOnClickListener {

        }


        return view
    }


}