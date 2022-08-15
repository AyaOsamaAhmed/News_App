package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.newsapp.databinding.DetailsFragmentBinding
import com.aya.newsapp.databinding.SettingFragmentBinding
import com.aya.newsapp.presentation.viewModel.DetailsViewModel

class SettingFragment : Fragment() {

    private lateinit var binding : SettingFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingFragmentBinding.inflate(inflater , container , false)

        return binding.root
    }
}