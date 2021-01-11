package com.dev.akukoifo.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev.akukoifo.R
import com.dev.akukoifo.adapters.akukuAdapter
import com.dev.akukoifo.adapters.egwuruegwuAdapter
import com.dev.akukoifo.model.AkukoDataClass
import com.dev.akukoifo.util.CloudFirestoredb
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class EgwuregwuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        CloudFirestoredb.retrieveEgwu()

        CloudFirestoredb.egwuusersDetails.observe(viewLifecycleOwner, Observer {

            root.egwurecycler.adapter =
                egwuruegwuAdapter(
                    it as ArrayList<AkukoDataClass>,
                    activity?.applicationContext!!
                )
        })
        return root
    }
}