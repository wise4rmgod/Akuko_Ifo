package com.dev.akukoifo.ui.langauagetranslator

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.akukoifo.R
import com.dev.akukoifo.databinding.FragmentAddBinding
import com.dev.akukoifo.databinding.LanguageTranslatorFragmentBinding
import com.dev.akukoifo.util.TranslateLang

class LanguageTranslatorFragment : Fragment() {

    lateinit var binding: LanguageTranslatorFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LanguageTranslatorFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        // return inflater.inflate(R.layout.language_translator_fragment, container, false)
        binding.sendWords.setOnClickListener {
            TranslateLang.translate()
        }

        binding.showwords.text = TranslateLang.usersDetails.value.toString()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}