package com.dev.akukoifo.ui.DetailsView

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dev.akukoifo.databinding.FragmentDetailsViewBinding


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


        binding.playvideo.setOnClickListener {

        }


        return view
    }


}