package com.dev.akukoifo.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dev.akukoifo.databinding.FragmentAddBinding
import com.dev.akukoifo.firebase.firestore.CloudFirestoredb
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root
        // val root = inflater.inflate(R.layout.fragment_add, container, false)


        val arrayvalue = arrayOf("akuko", "ilu", "egwuregwu")
        val adapter = ArrayAdapter(
            activity?.applicationContext!!,
            android.R.layout.simple_list_item_1,
            arrayvalue
        )
        view.autoCompletevalue.setAdapter(adapter)

        binding.save.setOnClickListener {
            CloudFirestoredb.save(
                activity?.applicationContext!!,
                binding.addtitle.text.toString(),
                binding.adddescription.text.toString(),
                binding.autoCompletevalue.text.toString(), ""
            )
        }

        binding.saveword.setOnClickListener {
            CloudFirestoredb.saveword(
                activity?.applicationContext!!,
                binding.addenglish.text.toString(),
                binding.addigbo.text.toString()
            )
        }


        return view
    }

}