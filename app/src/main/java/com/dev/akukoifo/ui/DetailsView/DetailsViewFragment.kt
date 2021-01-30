package com.dev.akukoifo.ui.DetailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.akukoifo.MainActivity
import com.dev.akukoifo.databinding.FragmentDetailsViewBinding
import kotlinx.android.synthetic.main.fragment_details_view.*


class DetailsViewFragment : Fragment() {

    private lateinit var binding: FragmentDetailsViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().actionBar?.setHomeButtonEnabled(true)
        // Inflate the layout for this fragment
        binding = FragmentDetailsViewBinding.inflate(inflater, container, false)
        val view = binding.root
        (activity as MainActivity?)?.setSupportActionBar(binding.toolbar)


        binding.playvideo.setOnClickListener {

        }


        return view
    }


}