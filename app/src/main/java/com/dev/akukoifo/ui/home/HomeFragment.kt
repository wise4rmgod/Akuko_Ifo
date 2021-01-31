package com.dev.akukoifo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dev.akukoifo.R
import com.dev.akukoifo.adapters.akukuAdapter
import com.dev.akukoifo.model.AkukoDataClass
import com.dev.akukoifo.firebase.firestore.CloudFirestoredb
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        // retrieve value from Cloud firestore database
        CloudFirestoredb.retrieveakuko()
        CloudFirestoredb.akukousersDetails.observe(viewLifecycleOwner, Observer {

            root.akukorecycler.adapter =
                akukuAdapter(
                    it as ArrayList<AkukoDataClass>,
                    activity?.applicationContext!!
                )
        })

        return root
    }
}