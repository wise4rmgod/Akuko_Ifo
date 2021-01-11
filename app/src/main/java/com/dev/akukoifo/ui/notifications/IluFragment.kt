package com.dev.akukoifo.ui.notifications

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
import com.dev.akukoifo.adapters.iluAdapter
import com.dev.akukoifo.model.AkukoDataClass
import com.dev.akukoifo.util.CloudFirestoredb
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class IluFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        CloudFirestoredb.retrieveIlu()

        CloudFirestoredb.iluusersDetails.observe(viewLifecycleOwner, Observer {
            root.egwurecycler.adapter =
                iluAdapter(
                    it as ArrayList<AkukoDataClass>,
                    activity?.applicationContext!!
                )
        })

        return root
    }
}