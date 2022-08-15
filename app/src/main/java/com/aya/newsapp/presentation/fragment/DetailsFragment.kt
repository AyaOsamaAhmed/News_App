package com.aya.newsapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.newsapp.databinding.DetailsFragmentBinding
import com.aya.newsapp.presentation.viewModel.DetailsViewModel

class DetailsFragment : Fragment() {

    private lateinit var binding : DetailsFragmentBinding
    private lateinit var viewModel: DetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

       // binding.model =

        return binding.root
    }
}